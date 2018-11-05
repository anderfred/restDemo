package com.example.rest.restDemo.service;

import com.example.rest.restDemo.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ItemService {
    <S extends Item> S save(S s);

    Optional<Item> findById(Integer id);

    Iterable<Item> findAll();

    Optional<Item> getByName(String name);

    void delete(Item user);
}
