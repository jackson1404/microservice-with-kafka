/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.microservice_kafka.order_service.dto.StockStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * ProductStockConsumer Class.
 * <p>
 * </p>
 *
 * @author
 */

@Component
public class ProductStockConsumer {

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
