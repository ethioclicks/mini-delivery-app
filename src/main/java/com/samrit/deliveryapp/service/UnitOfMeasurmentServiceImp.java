package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.UnitOfMeasurement;
import com.samrit.deliveryapp.repository.UnitOfMeasurmentRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasurmentServiceImp implements UnitOfMeasurmentService {
     private final UnitOfMeasurmentRepository unitOfMeasurmentRepository;

    public UnitOfMeasurmentServiceImp(UnitOfMeasurmentRepository unitOfMeasurmentRepository) {
        this.unitOfMeasurmentRepository = unitOfMeasurmentRepository;
    }

    @Override
    public Set<UnitOfMeasurement> listAllUoms() {
        return StreamSupport.stream(unitOfMeasurmentRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toSet());
    }
}
