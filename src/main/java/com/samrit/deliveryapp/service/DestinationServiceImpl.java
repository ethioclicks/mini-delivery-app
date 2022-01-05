package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Destination;
import com.samrit.deliveryapp.repository.DestinationRepository;
import org.springframework.stereotype.Service;

@Service
public class DestinationServiceImpl implements DestinationService {
    private  final DestinationRepository destinationRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }
}
