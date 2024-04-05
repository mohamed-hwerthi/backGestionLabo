package com.example.GestionLabo.exception;

public class PasswordNotRelyException extends RuntimeException {
    public PasswordNotRelyException(String message) {
        super("password not relie for this email address");
    }
}
