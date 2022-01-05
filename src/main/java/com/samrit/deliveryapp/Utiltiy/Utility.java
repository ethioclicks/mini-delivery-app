package com.samrit.deliveryapp.Utiltiy;

import com.samrit.deliveryapp.model.*;
import com.samrit.deliveryapp.service.OrderService;
import com.samrit.deliveryapp.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Component
public class Utility {

  private final   UserService userService;
  private final OrderService orderService;

    public Utility(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    public  Order mapToEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setCategories(orderDto.getCategories());
        order.setItemName(orderDto.getItemName());
        order.setItemDescription(orderDto.getItemDescription());
        order.setUnitOfMeasurement((orderDto.getUnitOfMeasurement()));
        order.setSize(orderDto.getSize());
        order.setUser(userService.findUserById(orderDto.getUserId()));

    return order;
    }

    public  Pickup mapToPickupEntity(PickupDto pickupDto) {
        Pickup pickup = new Pickup();
        pickup.setId(pickupDto.getId());
        pickup.setDate(pickup.getDate());
        pickup.setTime(pickupDto.getTime());
        pickup.setAddress(pickupDto.getAddress());
        pickup.setPickupRepresentative(pickupDto.getPickupRepresentative());
        pickup.setDirection(pickupDto.getDirection());
        pickup.setOrder(orderService.findById(pickupDto.getOrderId()));

        return pickup;
    }

    public  Destination mapToDestinationEntity(DestinationDto destinationDto) {
        Destination destination = new Destination();
        destination.setId(destinationDto.getId());
        destination.setDate(destinationDto.getDate());
        destination.setTime(destinationDto.getTime());
        destination.setAddress(destinationDto.getAddress());
        destination.setDestinationRepresentative(destinationDto.getDestinationRepresentative());
        destination.setInstruction(destinationDto.getInstruction());
        destination.setOrder(orderService.findById(destinationDto.getOrderId()));

        return destination;
    }
    @PostConstruct
    public void init(){
        User user1 = new User();
        user1.setFirstName("hew");
        user1.setLastName("sss");
        user1.setEmail("sss@yahoo.com");
        user1.setPassword("sss");
        userService.save(user1);
//
//        Order order = new Order();
//        order.setUser(user1);
//        order.setItemName("sged");
//        Date date = Date.valueOf("2020-05-05");
//        order.setDate(date);
////        order.setCategories(Category.get);
//        order.setItemDescription("sgedgd");
////        order.setUnitOfMeasurement("Pcs");
//        orderService.save(order);
//
//        Pickup pickUp = new Pickup();
//        pickUp.setAddress("sgdsgt3j sdgsgqe");
//        pickUp.setOrder(order);
//
//        Destination destination = new Destination();
//        destination.setAddress("ddsga");
//        destination.setOrder(order);
//
//        orderService.addPickUp(order.getId(), pickUp);
//        orderService.addDestination(order.getId(), destination);
//
//        Order order2 = new Order();
//        order2.setUser(user1);
//        order2.setItemName("sged");
//       Date date2 = Date.valueOf("2020-05-05");
//        order2.setDate(date2);
////        order.setCategories(Category.get);
//        order2.setItemDescription("sgedgd");
////        order.setUnitOfMeasurement("Pcs");
//        orderService.save(order2);
//
//        Pickup pickUp2 = new Pickup();
//        pickUp2.setAddress("sgdsgt3j sdgsgqe");
//        pickUp2.setOrder(order2);
//
//        Destination destination2 = new Destination();
//        destination2.setAddress("ddsga");
//        destination2.setOrder(order2);
//
//        orderService.addPickUp(order2.getId(), pickUp2);
//        orderService.addDestination(order2.getId(), destination2);



    }

}
