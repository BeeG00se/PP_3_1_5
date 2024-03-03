package ru.kata.spring.boot_security.demo.Exception;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
