package com.example.rest.restDemo.service;

import com.example.rest.restDemo.entity.Item;
import com.example.rest.restDemo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public <S extends Item> S save(S s) {
        return itemRepository.save(s);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getByName(String name) {
        return itemRepository.getByName(name);
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}
