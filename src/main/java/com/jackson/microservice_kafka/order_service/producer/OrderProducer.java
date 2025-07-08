package com.jackson.microservice_kafka.order_service.producer;

import com.jackson.microservice_kafka.order_service.model.OrderEntity;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Component
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.topics.order-created}")
    private String orderCreatedTopic;

    @Value("${app.topics.inventory-check}")
    private String inventoryCheckTopic;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(OrderEntity order){
        kafkaTemplate.send(orderCreatedTopic, order.getOrderNumber(), order);
        log.info("Order created event sent for order: {}", order.getOrderNumber());
    }

    public void checkInventoryEvent(OrderEntity order){
        kafkaTemplate.send(inventoryCheckTopic, order.getProductId(),
                Map.of(
                        "orderNumber", order.getOrderNumber(),
                        "productId", order.getProductId(),
                        "productQuantity", order.getQuantity()
                ));
        log.info("Inventory check event sent for product: {}", order.getProductId());
    }
}