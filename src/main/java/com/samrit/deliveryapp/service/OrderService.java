package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Destination;
import com.samrit.deliveryapp.model.Order;
import com.samrit.deliveryapp.model.Pickup;

import java.util.List;
import java.util.Optional;

public interface OrderService  {
    Order save(Order order) ;
    List<Order>  findAll(Long id);

    void addPickUp(Long id, Pickup pickUp);
    void addDestination(Long id, Destination destination);

    Order findById(Long orderId);
    List<Order>findAllById(Long id);
    List<Order>findByUserId(Long userId);
}
