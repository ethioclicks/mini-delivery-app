package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Item;
import com.samrit.deliveryapp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.awt.font.OpenType;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemServiceImp implements ItemService{
    private final ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Set<Item> getAllItems() {

        Set<Item> itemSet =  new HashSet<>();
        itemRepository.findAll().iterator().forEachRemaining(itemSet::add);

        return  itemSet;
    }

    @Override
    public Item findById(Long l) {
        Optional<Item> itemOptional = itemRepository.findById(l);
        if(!itemOptional.isPresent()){
            throw new RuntimeException("Item Not Found");
        }
        return itemOptional.get();
    }

    @Override
    public Item saveItem( Item item) {
        Item itemSave = itemRepository.save(item);
        return item;
    }
    @Override
    public void deleteById(Long idToDelete) {
        itemRepository.deleteById(idToDelete);
    }
}
