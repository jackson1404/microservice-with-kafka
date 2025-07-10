package com.jackson.microservice_kafka.order_service.producer;

import com.jackson.enumerate.EventType;
import com.jackson.microservice_kafka.order_service.dto.InventoryProducerDto;
import com.jackson.microservice_kafka.order_service.model.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderProducer {

    private final KafkaTemplate<String, InventoryProducerDto> kafkaTemplate;

    @Value("${app.topics.order-created}")
    private String orderCreatedTopic;

    @Value("${app.topics.inventory-check}")
    private String inventoryCheckTopic;

    public OrderProducer(KafkaTemplate<String, InventoryProducerDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(OrderEntity order){

        InventoryProducerDto dto = new InventoryProducerDto(
                order.getProductId(),
                order.getOrderNumber(),
                order.getQuantity(),
                EventType.ORDER_CREATED
        );

        kafkaTemplate.send(orderCreatedTopic, order.getOrderNumber(), dto);
        log.info("Order created event sent for order: {}", order.getOrderNumber());
    }

    public void checkInventoryEvent(OrderEntity order){

        InventoryProducerDto dto = new InventoryProducerDto(
                order.getProductId(),
                order.getOrderNumber(),
                order.getQuantity(),
                EventType.INVENTORY_CHECK_REQUESTED
        );

        kafkaTemplate.send(inventoryCheckTopic, String.valueOf(order.getProductId()), dto);
        log.info("Inventory check event sent for product: {}", order.getProductId());
    }
}