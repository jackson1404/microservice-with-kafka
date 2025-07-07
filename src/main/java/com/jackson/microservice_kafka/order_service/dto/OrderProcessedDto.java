/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.microservice_kafka.order_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * OrderProcessedDto Class.
 * <p>
 * </p>
 *
 * @author
 */

@Data
@RequiredArgsConstructor
public class OrderProcessedDto {

    private String orderNumber;
    private String orderStatus;
}


