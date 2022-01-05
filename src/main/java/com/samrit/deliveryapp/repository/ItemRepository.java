package com.samrit.deliveryapp.repository;



import com.samrit.deliveryapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    //Optional<Category> findByDescription(String description);

}
