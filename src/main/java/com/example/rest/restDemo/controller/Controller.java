package com.example.rest.restDemo.controller;

import com.example.rest.restDemo.entity.Item;
import com.example.rest.restDemo.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private ItemService itemService;

    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/item")
    public Item index() {
        return itemService.getByName("fredx").isPresent() ? itemService.getByName("fredx").get() : null;
    }

}
