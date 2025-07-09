/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * OrderProcessedDto Class.
 * <p>
 * </p>
 *
 * @author
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProcessedDto {

    private String orderNumber;
    private String status;
    private String message;

}


