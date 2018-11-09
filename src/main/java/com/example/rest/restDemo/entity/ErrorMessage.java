package com.example.rest.restDemo.entity;

import java.util.Date;

public class ErrorMessage {
    private String message;
    private Date date;

    public ErrorMessage(
    ) {
        this.message = "Value not found";
        this.date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
