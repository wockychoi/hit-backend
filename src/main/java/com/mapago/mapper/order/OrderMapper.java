package com.mapago.mapper.order;

import com.mapago.model.user.PostingLog;
import com.mapago.model.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 주문 목록 조회
    List<Order> getOrderList(Order order);

    // 단건 조회
    Order findById(Long orderSeq);

    // 주문 저장
    void insertOrder(Order order);

    // 주문 수정
    int updateOrder(Order order);

    // 주문 삭제
    int deleteOrder(Long orderSeq);
}