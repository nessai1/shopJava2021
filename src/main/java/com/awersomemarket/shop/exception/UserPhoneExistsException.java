package com.awersomemarket.shop.exception;

public class UserPhoneExistsException extends RuntimeException {
    public UserPhoneExistsException(String message) { super(message); }
}
