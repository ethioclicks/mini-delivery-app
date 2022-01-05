package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Pickup;
import com.samrit.deliveryapp.repository.PickupRepository;
import org.springframework.stereotype.Service;

@Service
public class PickupServiceImpl implements PickupService {

    private final  PickupRepository pickupRepository;

    public PickupServiceImpl(PickupRepository pickupRepository) {
        this.pickupRepository = pickupRepository;
    }

    @Override
    public Pickup save(Pickup pickup) {
        return pickupRepository.save(pickup);
    }
}
