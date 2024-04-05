package com.example.GestionLabo.exception;

public class UserWithEmailNotFoundException extends RuntimeException {
    public UserWithEmailNotFoundException(String email) {
        super(" this email not found :" + email);
    }
}
