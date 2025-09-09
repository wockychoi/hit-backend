package com.mapago.service.order;

import com.mapago.config.exception.CustomException;
import com.mapago.mapper.order.OrderMapper;
import com.mapago.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 주문 목록 조회
     */
    public List<Order> getOrderList(Order order) throws Exception {
        return orderMapper.getOrderList(order);
    }

    /**
     * 주문 단건 조회
     */
    public Order findById(Long orderSeq) {
        return orderMapper.findById(orderSeq);
    }

    /**
     * 주문 등록
     */
    @Transactional
    public Order insertOrder(Order order) throws Exception {
        orderMapper.insertOrder(order);
        return order;
    }

    /**
     * 주문 수정
     */
    @Transactional
    public Order updateOrder(Order order) throws Exception {
        int result = orderMapper.updateOrder(order);
        return Optional.ofNullable(order)
                .filter(t -> result > 0)
                .orElseThrow(() -> new CustomException("수정할 주문이 없습니다."));
    }

    /**
     * 주문 삭제
     */
    @Transactional
    public void deleteOrder(Long orderSeq) throws Exception {
        int result = orderMapper.deleteOrder(orderSeq);
        if (result == 0) {
            throw new CustomException("삭제할 주문이 없습니다.");
        }
    }
}
