/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AppTopicProperties Class.
 * <p>
 * </p>
 *
 * @author
 */

@ConfigurationProperties(prefix = "app")
public record AppTopicProperties(Topics topics, Kafka kafka) {

    public record Topics(String orderCreated, String orderProcessed,
                         String inventoryCheck, String inventoryUpdated){}

    public record Kafka(ConsumerGroups consumerGroups){

        public record ConsumerGroups (String orderCreated, String orderProcessed,
                                      String inventoryCheck, String inventoryUpdated){}

    }
}
