package com.example.rest.restDemo.controller;

import com.example.rest.restDemo.entity.Item;
import com.example.rest.restDemo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);
    private ItemService itemService;

    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/item")
    public Item index() {
        Item item = itemService.getByName("fredx").get();
        if (item != null) {
            logger.info("/item REST {}", item);
            return item;
        }
        return null;
    }

}
