package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Destination;
import com.samrit.deliveryapp.model.Order;
import com.samrit.deliveryapp.model.Pickup;
import com.samrit.deliveryapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PickupService pickupService;
    private final DestinationService destinationService;

    public OrderServiceImpl(OrderRepository orderRepository, PickupService pickupService, DestinationService destinationService) {
        this.orderRepository = orderRepository;
        this.pickupService = pickupService;
        this.destinationService = destinationService;
    }

    @Override
    public Order save(Order order) {
        Order orderSaved = orderRepository.save(order);
        return orderSaved;
    }

    @Override
    public List<Order> findAll(Long id) {
       List<Order>orderList = orderRepository.findAll();
        return orderList;
    }

    @Override
    public void addPickUp(Long id, Pickup pickUp) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            //save pickup
            Pickup savePicup = pickupService.save(pickUp);

           Order order = orderOptional.get();
           order.setPickup(savePicup);

           orderRepository.save(order);
        }
    }

    @Override
    public void addDestination(Long id, Destination destination) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            //save pickup
            Destination saveDestination = destinationService.save(destination);

            Order order = orderOptional.get();
            order.setDestination(saveDestination);

            orderRepository.save(order);
        }
    }

    @Override
    public Order findById(Long orderId) {
        Optional <Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()){
            return orderOptional.get();
        }else{
            return null;
        }
       // return orderOptional.get();
    }

    @Override
    public List<Order> findAllById(Long id) {
      //  Optional<Order> orderOptional = orderRepository.findById(id);
        return orderRepository.findAllById(id);
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        List<Order> byUserId = orderRepository.findByUserId(userId);
        return byUserId;
    }

}
