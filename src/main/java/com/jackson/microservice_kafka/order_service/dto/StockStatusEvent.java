package com.jackson.microservice_kafka.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StockStatusEvent {

    private Long productId;
    private String productName;
    //    private int productQuantity;
    private String status; // e.g., OUT_OF_STOCK, LOW
    private String timestamp;

    public StockStatusEvent(Long productId, String productName, String status, String timestamp) {
        this.productId = productId;
        this.productName = productName;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public StockStatusEvent(){}
}