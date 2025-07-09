package com.jackson.microservice_kafka.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

public class OrderRequestDto {

    private String orderNumber;
    private String customerId;
    private Long productId;
    private int quantity;
    private Double totalPrice;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderRequestDto(){}
    public OrderRequestDto(Double totalPrice, int quantity, Long productId, String customerId, String orderNumber) {
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.productId = productId;
        this.customerId = customerId;
        this.orderNumber = orderNumber;
    }
}
