package com.jackson.microservice_kafka.order_service.dto;

import com.jackson.enumerate.EventType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryProducerDto {

        private Long productId;
        private String orderNumber;
        private int orderQuantity;
        private EventType eventType;

    public InventoryProducerDto(Long productId, String orderNumber, int orderQuantity, EventType eventType) {
        this.productId = productId;
        this.orderNumber = orderNumber;
        this.orderQuantity = orderQuantity;
        this.eventType = eventType;
    }

}
