package com.example.GestionLabo.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String element, String id) {
        super(element + " not found  with id  :" + id);
    }
}
