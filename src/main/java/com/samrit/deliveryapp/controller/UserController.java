package com.samrit.deliveryapp.controller;

import com.samrit.deliveryapp.model.Order;
import com.samrit.deliveryapp.model.OrderDto;
import com.samrit.deliveryapp.model.User;
import com.samrit.deliveryapp.service.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
//@RequestMapping({"/users"})
@RequestMapping()
public class UserController {

    private final UserService userService;
    private final OrderService orderService;
    private static final String USER_REGISTRATION_FORM = "User/registration";
    private static final String USER_LOGIN_FORM = "User/login";


    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/registration")
    public String initCreationForm(Model model) {
        model.addAttribute("user", User.builder().build());
        return USER_REGISTRATION_FORM;
    }

    @PostMapping("/registration")
    public String registerUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect: /registration";
        } else {
            User saveUser = userService.save(user);
            return "redirect:/login";

        }
    }

    @GetMapping("/login")
    public String initLoginForm(Model model) {
        model.addAttribute("user", User.builder().build());
        return USER_LOGIN_FORM;
    }
    @PostMapping("/login")
    public String logUser( User user, BindingResult result, Model model){

        if (user.getLastName() == null) {
            user.setLastName(""); // empty string signifies broadest possible search
        }
        User user1 = userService.findByEmail(user.getEmail());
        //  System.out.println(user1);
        if (user1 != null && (user1.getPassword().equals(user.getPassword()) ) ) {

            model.addAttribute("user", user1);
          //  List<Order> orderList = orderService.findAllById(user1.getId());
           List<Order>  orderList = orderService.findByUserId(user1.getId());

            System.out.println(orderList);
            if(orderList != null){
                model.addAttribute("orders",orderList) ;

            }
            return "redirect:/dashboard/"+user1.getId();
        } else {
            result.rejectValue("User Name or Password is not correct", "notFound", "not found");
            return USER_LOGIN_FORM;
        }

    }

    //@GetMapping("/destination/{orderId}")
    @GetMapping("/dashboard/{userId}")
    public String showUserDashboard(@PathVariable Long userId, User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "redirect:/login";
        } else {
            user = userService.findUserById(userId);
            List<Order>  orderList = orderService.findByUserId(user.getId());
            // List<Order> order = (List<Order>) orderService.findById(user1.getId());
            System.out.println(orderList);
            if(orderList != null){
                model.addAttribute("orders",orderList) ;
            }
            // user = user1;
            model.addAttribute("user", user);

            return "Dashboard";

        }
    }
    }


