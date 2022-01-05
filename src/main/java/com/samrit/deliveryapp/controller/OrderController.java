package com.samrit.deliveryapp.controller;

import com.samrit.deliveryapp.Utiltiy.Utility;
import com.samrit.deliveryapp.model.*;
import com.samrit.deliveryapp.repository.UserRepository;
import com.samrit.deliveryapp.service.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class OrderController {

    private final OrderService orderService;
    private final UnitOfMeasurmentService unitOfMeasureService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;
    private final Utility utility;
    private final PickupService pickupService;
    private final DestinationService destinationService;


    public OrderController(OrderService orderService, UnitOfMeasurmentService unitOfMeasureService, CategoryService categoryService, UserRepository userRepository, Utility utility, PickupService pickupService, DestinationService destinationService) {
        this.orderService =orderService ;
        this.unitOfMeasureService = unitOfMeasureService;
        this.categoryService = categoryService;
        this.userRepository = userRepository;
        this.utility = utility;
        this.pickupService = pickupService;
        this.destinationService = destinationService;
    }
    @GetMapping("/order/{userId}")
    public String newItem(@PathVariable Long userId, Order order, Model model){

        OrderDto orderDto = new OrderDto();
        Optional<User> user1 = userRepository.findById(userId);
        System.out.println(user1);
        User user = user1.get();
        user.getOrders().add(order);
        orderDto.setUserId(user.getId());
        //init uom
        orderDto.setUnitOfMeasurement(new UnitOfMeasurement());
        orderDto.setCategories(new Category());
        model.addAttribute("category", categoryService.listAllCategories() );
        model.addAttribute("uomList",  unitOfMeasureService.listAllUoms());
        model.addAttribute("orders", orderDto);

        return "OrderItem";
    }
    @PostMapping("/order")
    public  String saveUpdateOrder(@ModelAttribute OrderDto orderDto, BindingResult result,Model model){
        if(result.hasErrors()){
            return "ItemRegistration";
        }else{
            Order order=  utility.mapToEntity(orderDto);
            Order saveOrder = orderService.save(order);
            System.out.println(saveOrder);

            model.addAttribute("orders", saveOrder);
            model.addAttribute("pickup", new Pickup());

            return "redirect:/pickup/"+saveOrder.getId();
        }
    }
    @GetMapping("/pickup/{orderId}")
    public String getPickupForm(@PathVariable Long orderId, Pickup pickup, Model model){
        PickupDto pickupDto = new PickupDto();
        Order orderOptional = orderService.findById(orderId);
        System.out.println(orderOptional);
        Order newOrder = orderOptional;
        newOrder.setPickup(pickup);
        pickupDto.setOrderId(newOrder.getId());
        model.addAttribute("pickup", pickupDto);

        return "pickup";

    }

    @PostMapping("/pickup")
    public String saveUpdatePickup(@ModelAttribute PickupDto pickupDto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "pickup";
        } else {
            Pickup pickup = utility.mapToPickupEntity(pickupDto);
            Pickup pickUpsave = pickupService.save(pickup);
            orderService.addPickUp(pickupDto.getOrderId(), pickUpsave);

            model.addAttribute("pickup", new Pickup());

              return "redirect:/destination/"+pickupDto.getOrderId();

        }
    }

    @GetMapping("/destination/{orderId}")
    public String getDestinationForm(@PathVariable Long orderId, Destination destination, Model model){
        DestinationDto destinationDto = new DestinationDto ();
        Order orderOptional = orderService.findById(orderId);
        System.out.println(orderOptional);
        Order newOrder = orderOptional;
        newOrder.setDestination(destination);
        destinationDto.setOrderId(newOrder.getId());
        model.addAttribute("destination", destinationDto);

        return "destination";

    }

    @PostMapping("/destination")
    public String saveUpdateDestination(@ModelAttribute DestinationDto destinationDto, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "destination";
        } else {
            Destination destination = utility.mapToDestinationEntity(destinationDto);
            Destination destinationSave = destinationService.save(destination);
            orderService.addDestination(destinationDto.getOrderId(), destinationSave);

            model.addAttribute("destination", new Destination());

            //return  "conformation";

            return "redirect:/conformation/"+destinationDto.getOrderId();

        }
    }
    @GetMapping("/conformation/{orderId}")
    public String getConformationform(@PathVariable Long orderId,  Model model){
        //OrderDto orderDto = new OrderDto ();
        Order orderOptional = orderService.findById(orderId);
        System.out.println(orderOptional);

        model.addAttribute("orders", orderOptional);

        return "conformation";

    }

@PostMapping("/conformation/{orderId}")
    public String conformOrder( @PathVariable Long orderId,  Order order, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()) {
        return "redirect: /conformation/"+ order.getId();
    } else {

        Order orderConformed = orderService.findById(orderId);
        order = orderConformed;
        List<Order> orderList = orderService.findAllById(order.getUser().getId());
        model.addAttribute("orders", orderList);

        return "redirect:/dashboard/"+ order.getUser().getId();


    }

}

}
