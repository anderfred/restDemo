package com.example.rest.restDemo.controller;

import com.example.rest.restDemo.entity.Item;
import com.example.rest.restDemo.exceptions.ItemNotFoundException;
import com.example.rest.restDemo.service.ItemService;
import com.example.rest.restDemo.service.UserService;
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
        if (itemService.findById(id).isPresent()) return itemService.findById(id).get();
        else throw new ItemNotFoundException(""+id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/save")
    public void save(@RequestHeader(value = "ID-TOKEN") String idToken) throws Exception {
        service.saveUser(idToken);
    }

}
