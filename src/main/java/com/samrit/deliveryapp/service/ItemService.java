package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Item;

import java.util.Set;

public interface ItemService {
    Set<Item> getAllItems();
    Item findById(Long l);
    Item saveItem(Item item);
    void deleteById(Long idToDelete);

}
