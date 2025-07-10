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

public class OrderProcessedDto {

    private String orderNumber;
    private String status;
    private String message;

    public OrderProcessedDto(){}
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderProcessedDto(String orderNumber, String status, String message) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.message = message;
    }
}


