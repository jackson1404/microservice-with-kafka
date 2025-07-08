/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.consumer;

import com.jackson.microservice_kafka.order_service.config.AppTopicProperties;
import com.jackson.microservice_kafka.order_service.dto.OrderProcessedDto;
import com.jackson.microservice_kafka.order_service.dto.OrderRequestDto;
import com.jackson.microservice_kafka.order_service.enumerate.OrderStatus;
import com.jackson.microservice_kafka.order_service.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.hibernate.query.Order;
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
@Getter
public class OrderConsumer {
    private final AppTopicProperties appTopicProperties;

    private final OrderService orderService;

    @KafkaListener(topics = "#{appTopicProperties.topics.orderProcessed}", groupId = "#{appTopicProperties.kafka.consumerGroups.orderProcessed}")
    public void consumeOrderProcessed(ConsumerRecord<String, OrderProcessedDto> record) {

        OrderProcessedDto orderProcessedDto = record.value();

        String orderNumber = orderProcessedDto.getOrderNumber();
        String orderStatus = orderProcessedDto.getOrderStatus();

        OrderStatus orderFinalStatus = "SUCCESS".equals(orderStatus)?
                OrderStatus.COMPLETED: OrderStatus.FAILED;

        orderService.updateOrderStatus(orderNumber, orderFinalStatus);

    }



}
