package com.samrit.deliveryapp.repository;

import com.samrit.deliveryapp.model.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UnitOfMeasurmentRepository extends JpaRepository<UnitOfMeasurement, Long>{
    Optional<UnitOfMeasurement> findByDescription(String description);

}
