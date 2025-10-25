package ru.ivanov.ecommerceplatformproject.userservice.exception;


public class UsernameIsTakenException extends RuntimeException {
    public UsernameIsTakenException(String message) {
        super(message);
    }
}