package com.mapago.controller.admin.user;

import com.mapago.model.user.User;
import com.mapago.service.user.UserService;
import com.mapago.util.AesUtil;
import com.mapago.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api/user")
public class AdmUserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final Set<Cookie> cookies;
    private static final Map<String, String> cookieStorage = new HashMap<>();


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User loginRequest) {
        try {
            // 🔓 1. 클라이언트에서 받은 비밀번호 복호화
            String decryptedPasswordFromClient = AesUtil.decrypt(loginRequest.getPassword());

            // 🔍 2. 사용자 조회
            User user = userService.findByUserId(loginRequest.getUserId());
            if (user == null) {
                return ResponseEntity.status(401).body(Map.of("error", "존재하지 않는 아이디입니다."));
            }

            // 🔓 3. DB에 저장된 암호화된 비밀번호도 복호화
            String decryptedPasswordFromDB = AesUtil.decrypt(user.getPassword());

            // 🔐 4. 두 복호화된 비밀번호 비교
            if (!decryptedPasswordFromClient.equals(decryptedPasswordFromDB)) {
                return ResponseEntity.status(401).body(Map.of("error", "비밀번호가 일치하지 않습니다."));
            }

            // ✅ 5. 로그인 성공 처리
            UserDetails userDetails = userService.loadUserByUsername(user.getUserId());
            user.setRoles(userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()));

            String accessToken = jwtUtil.generateAdminAccessToken(user.getUserId());
            String refreshToken = jwtUtil.generateAdminRefreshToken(user.getUserId());

            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", accessToken);
            response.put("refreshToken", refreshToken);
            response.put("user", user);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "오류가 발생했습니다. 운영자에게 문의 해주세요."));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(User user) throws Exception {
        return ResponseEntity.ok(userService.getUserList(user));
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.insertUser(user));
    }

    @GetMapping("/duplicate")
    public ResponseEntity<?> duplicate(@RequestParam String userId) throws Exception {
        return ResponseEntity.ok(userService.findByUserId(userId));
    }


}