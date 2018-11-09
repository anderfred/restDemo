package com.example.rest.restDemo.controller;

import com.example.rest.restDemo.entity.Item;
import com.example.rest.restDemo.exceptions.AlreadyPresentException;
import com.example.rest.restDemo.exceptions.ItemNotFoundException;
import com.example.rest.restDemo.service.ItemService;
import com.example.rest.restDemo.service.UserService;
import com.mysql.cj.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);
    private ItemService itemService;

    private final UserService service;

    public Controller(ItemService itemService, UserService service) {
        this.itemService = itemService;
        this.service = service;
    }

    @RequestMapping("/items")
    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        itemService.findAll().forEach(list::add);
        logger.info("/items {}", list);
        return list;
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    public Item replaceItem(@RequestBody Item newItem) {
        if (itemService.findById(newItem.getId()).isPresent()) {
            Item item = itemService.findById(newItem.getId()).get();
            item.setName(newItem.getName());
            itemService.save(item);
            return item;
        } else throw new ItemNotFoundException(newItem.getId());
    }

    @PostMapping("/items/{id}")
    public Item createItem(@RequestBody Item item) {
        if (!itemService.findById(item.getId()).isPresent()) {
            itemService.save(item);
            return item;
        } else throw new AlreadyPresentException(item);
    }
}
