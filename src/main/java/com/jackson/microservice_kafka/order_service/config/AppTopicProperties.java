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
import org.springframework.stereotype.Component;

/**
 * AppTopicProperties Class.
 * <p>
 * </p>
 *
 * @author
 */

@Component
@ConfigurationProperties(prefix = "app")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTopicProperties {

    private Topics topics;

    private Kafka kafka;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Topics{
        private String orderCreated;
        private String orderProcessed;
        private String inventoryCheck;
        private String inventoryUpdated;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Kafka{
        private ConsumerGroups consumerGroups;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ConsumerGroups{

            private String orderCreated;
            private String orderProcessed;
            private String inventoryCheck;
            private String inventoryUpdated;
            private String notificationOrderCreated;
            private String notificationOrderProcessed;
            private String notificationInventoryCheck;

        }
    }

}
