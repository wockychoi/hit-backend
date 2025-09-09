package com.mapago.controller.admin.order;

import com.mapago.model.order.Order;
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
import java.util.List;
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
    public ResponseEntity<?> list(Order order) throws Exception {
        return ResponseEntity.ok(orderService.getOrderList(order));
    }


    // 여러 주문 수정
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody List<Order> orders) throws Exception {
        for (Order order : orders) {
            orderService.updateOrder(order);
        }
        return ResponseEntity.ok("✅ 선택 주문이 수정되었습니다.");
    }

    // 여러 주문 저장
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody List<Order> orders) throws Exception {
        for (Order order : orders) {
            orderService.insertOrder(order);
        }
        return ResponseEntity.ok("✅ 선택 주문이 저장되었습니다.");
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody List<Long> orderSeqList) throws Exception {
        for (Long orderSeq : orderSeqList) {
            orderService.deleteOrder(orderSeq);
        }
        return ResponseEntity.ok("✅ 선택 주문이 삭제되었습니다.");
    }





}