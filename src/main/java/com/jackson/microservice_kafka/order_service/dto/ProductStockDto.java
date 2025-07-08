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
 * ProductStockDto Class.
 * <p>
 * </p>
 *
 * @author
 */


@Data
@RequiredArgsConstructor
public class ProductStockDto {

    private String productId;
    private String productName;
    private String status;
    private String timeStamp;

    public ProductStockDto(String productId, String productName, String status, String timeStamp) {
        this.productId = productId;
        this.productName = productName;
        this.status = status;
        this.timeStamp = timeStamp;
    }
}