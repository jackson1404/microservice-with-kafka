/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.consumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.microservice_kafka.order_service.dto.OrderProcessedDto;
import com.jackson.microservice_kafka.order_service.dto.OrderRequestDto;
import com.jackson.microservice_kafka.order_service.dto.StockStatusEvent;
import com.jackson.microservice_kafka.order_service.enumerate.OrderStatus;
import com.jackson.microservice_kafka.order_service.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * OrderConsumer Class.
 * <p>
 * </p>
 *
 * @author
 */

@Component
@RequiredArgsConstructor
@Data
public class OrderConsumer {


    @Value("${app.topics.order-processed}")
    private String orderProcessedTopic;

    @Value("${app.kafka.consumer-groups.order-processed}")
    private String orderProcessedGroup;

    private final OrderService orderService;

    @KafkaListener(topics = "#{__listener.orderProcessedTopic}", groupId = "#{__listener.orderProcessedGroup}")
    public void consumeOrderProcessed(ConsumerRecord<String, OrderProcessedDto> record) {

        OrderProcessedDto orderProcessedDto = record.value();

        String orderNumber = orderProcessedDto.getOrderNumber();
        String orderStatus = orderProcessedDto.getOrderStatus();

        OrderStatus orderFinalStatus = "SUCCESS".equals(orderStatus)?
                OrderStatus.COMPLETED: OrderStatus.FAILED;

        orderService.updateOrderStatus(orderNumber, orderFinalStatus);

    }

    @KafkaListener(topics = "stock-status", groupId = "order-service")
    public void consume(String messageJson) throws JsonProcessingException {
        System.out.println("Received raw message: " + messageJson);

        ObjectMapper mapper = new ObjectMapper();
        StockStatusEvent event = mapper.readValue(messageJson, StockStatusEvent.class);

        if ("OUT_OF_STOCK".equalsIgnoreCase(event.getStatus())) {
            System.out.println("🛑 Order Service: Item out of stock -> " + event.getProductName());
            // Logic: prevent orders for this item
        }
    }

}
