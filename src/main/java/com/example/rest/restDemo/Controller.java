package com.example.rest.restDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public Item index(){
        return new Item("fredx", 22);
    }
}
