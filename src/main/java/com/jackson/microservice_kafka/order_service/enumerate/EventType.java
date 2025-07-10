package com.jackson.microservice_kafka.order_service.enumerate;

public enum EventType {
    ORDER_CREATED,
    INVENTORY_CHECK_REQUESTED,
    INVENTORY_RESERVED,
    INVENTORY_OUT_OF_STOCK,
    PAYMENT_PROCESSED,
    PAYMENT_FAILED,
    ORDER_COMPLETED,
    ORDER_CANCELLED
}
