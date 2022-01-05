package com.samrit.deliveryapp.Bootstrap;

import com.samrit.deliveryapp.model.UnitOfMeasurement;
import com.samrit.deliveryapp.repository.OrderRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final OrderRepository orderRepository;

    public DataLoader(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
