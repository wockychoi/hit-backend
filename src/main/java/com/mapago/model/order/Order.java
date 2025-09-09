package com.mapago.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mapago.model.Audit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order extends Audit {
    private Long orderSeq;          // 주문 시퀀스 (PK)
    private String userId;          // 거래처 (users.user_id 참조)

    private LocalDate shippingDate; // 출고일자
    private String courier;         // 택배사
    private String trackingNo;      // 송장번호
    private LocalDate orderDate;    // 주문일자
    private String orderType;       // 구분
    private String customerName;    // 거래처명
    private String ordererName;     // 주문자
    private String recPerson;       // 수령자
    private String productCode;     // 상품 고유번호
    private String phoneNumber;     // 휴대전화
    private String productName;     // 상품명
    private String paymentMethod;   // 결제수단
    private String postalCode;      // 우편번호
    private Integer quantity;       // 수량
    private Integer unitPrice;      // 단가
    private Integer amount;         // 금액
    private Integer shippingFee;    // 택배비
    private Integer totalAmount;    // 총 결제금액
    private String deliveryMessage; // 배송메세지
    private String adminMemo;       // 관리자 메모
    private String deliveryAddress; // 배송지
}
