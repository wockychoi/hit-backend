package com.mapago.controller.admin.order;

import com.mapago.model.user.User;
import com.mapago.service.order.OrderService;
import com.mapago.service.user.UserService;
import com.mapago.util.AesUtil;
import com.mapago.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/api/order")
public class AdmOrderController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final OrderService orderService;
    private final Set<Cookie> cookies;
    private static final Map<String, String> cookieStorage = new HashMap<>();


    @GetMapping("/list")
    public ResponseEntity<?> list(User user) throws Exception {
        return ResponseEntity.ok(orderService.getUserList(user));
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(orderService.updateUser(user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(orderService.insertUser(user));
    }

    @GetMapping("/duplicate")
    public ResponseEntity<?> duplicate(@RequestParam String userId) throws Exception {
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }


}