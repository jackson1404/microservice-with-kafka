package com.jackson.microservice_kafka.order_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

}
