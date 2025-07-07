package com.jackson.microservice_kafka.order_service.repository;

import com.jackson.microservice_kafka.order_service.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByOrderNumber(String orderNumber);
}
