package com.example.rest.restDemo.repository;

import com.example.rest.restDemo.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    Optional<Item> getByName(String name);
}
