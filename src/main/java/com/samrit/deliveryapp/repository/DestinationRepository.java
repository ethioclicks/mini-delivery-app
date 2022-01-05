package com.samrit.deliveryapp.repository;

import com.samrit.deliveryapp.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository  extends JpaRepository<Destination, Long> {
}
