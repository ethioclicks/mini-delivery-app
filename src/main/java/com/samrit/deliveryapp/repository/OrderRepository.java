package com.samrit.deliveryapp.repository;

import com.samrit.deliveryapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllById(Long id);
    List<Order> findByUserId(Long userId);
}
