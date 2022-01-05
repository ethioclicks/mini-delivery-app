package com.samrit.deliveryapp.repository;

import com.samrit.deliveryapp.model.Pickup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupRepository extends JpaRepository<Pickup, Long> {
}
