package com.example.rest.restDemo.exceptions;

import com.example.rest.restDemo.entity.Item;

public class AlreadyPresentException extends RuntimeException {
    public AlreadyPresentException(Item item) {
        super("Error item already present:" + item.toString());
    }
}
