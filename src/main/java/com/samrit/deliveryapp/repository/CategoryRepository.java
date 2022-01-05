package com.samrit.deliveryapp.repository;

import com.samrit.deliveryapp.model.Category;
import com.samrit.deliveryapp.model.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
