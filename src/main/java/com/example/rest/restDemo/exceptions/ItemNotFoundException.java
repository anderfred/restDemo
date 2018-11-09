package com.example.rest.restDemo.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(int id) {
        super("Item not found, id:" + id);
    }
}
