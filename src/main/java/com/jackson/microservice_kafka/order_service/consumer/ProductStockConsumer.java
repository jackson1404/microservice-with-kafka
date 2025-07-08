/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Value("${app.topics.stock-check}")
    private String stockCheckTopic;

    @Value("${app.kafka.consumer-groups.stock-check}")
    private String stockCheckGroup;

    @KafkaListener(topics = "#{__listener.stockCheckTopic}", groupId = "#{__listener.stockCheckGroup}")
    public void productStockConsume(String messageJson){

        ObjectMapper objectMapper = new ObjectMapper();


    }

}
