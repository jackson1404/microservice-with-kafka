package com.jackson.microservice_kafka.order_service.dto;

import com.jackson.microservice_kafka.order_service.enumerate.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private String orderNumber;
    private String customerId;
    private String productId;
    private int quantity;
    private Double totalPrice;

}
