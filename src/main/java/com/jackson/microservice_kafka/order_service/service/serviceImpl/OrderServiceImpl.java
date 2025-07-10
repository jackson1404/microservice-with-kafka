package com.jackson.microservice_kafka.order_service.service.serviceImpl;

import com.jackson.microservice_kafka.order_service.dto.OrderRequestDto;
import com.jackson.microservice_kafka.order_service.enumerate.OrderStatus;
import com.jackson.microservice_kafka.order_service.model.OrderEntity;
import com.jackson.microservice_kafka.order_service.producer.OrderProducer;
import com.jackson.microservice_kafka.order_service.repository.OrderRepository;
import com.jackson.microservice_kafka.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProducer orderProducer;

    @Override
    public OrderEntity createOrder(OrderRequestDto orderRequestDto) {
        OrderEntity order = new OrderEntity();
        order.setOrderNumber(orderRequestDto.getOrderNumber());
        order.setCustomerId(orderRequestDto.getCustomerId());
        order.setQuantity(orderRequestDto.getQuantity());
        order.setProductId(orderRequestDto.getProductId());
        order.setTotalPrice(orderRequestDto.getTotalPrice());
        order.setStatus(OrderStatus.CREATED);

        OrderEntity savedOrder = orderRepository.save(order);
        // add order create event
        orderProducer.sendOrderCreatedEvent(savedOrder);
        // add inventory check event
        orderProducer.checkInventoryEvent(savedOrder);

        return savedOrder;
    }

    @Override
    public void updateOrderStatus(String orderNumber, OrderStatus orderFinalStatus) {
        orderRepository.findByOrderNumber(orderNumber)
                .ifPresent(order -> {
                    order.setStatus(orderFinalStatus);
                    orderRepository.save(order);
                });
    }
}
