package com.jackson.microservice_kafka.order_service.service;

import com.jackson.microservice_kafka.order_service.dto.OrderRequestDto;
import com.jackson.microservice_kafka.order_service.model.OrderEntity;

public interface OrderService {

    OrderEntity createOrder(OrderRequestDto orderRequestDto);
}
