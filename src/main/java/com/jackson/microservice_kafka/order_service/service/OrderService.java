package com.jackson.microservice_kafka.order_service.service;

import com.jackson.microservice_kafka.order_service.dto.OrderRequestDto;
import com.jackson.microservice_kafka.order_service.enumerate.OrderStatus;
import com.jackson.microservice_kafka.order_service.model.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    OrderEntity createOrder(OrderRequestDto orderRequestDto);

    void updateOrderStatus(String orderNumber, OrderStatus orderFinalStatus);
}
