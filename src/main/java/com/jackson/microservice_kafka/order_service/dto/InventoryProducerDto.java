package com.jackson.microservice_kafka.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryProducerDto {

        private Long productId;
        private String orderNumber;
        private int orderQuantity;

    public InventoryProducerDto(Long productId, String orderNumber, int orderQuantity) {
        this.productId = productId;
        this.orderNumber = orderNumber;
        this.orderQuantity = orderQuantity;
    }

}
