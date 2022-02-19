package com.awersomemarket.shop.exception;

public class IncorrectOrderStatusChangeException extends RuntimeException {
    public IncorrectOrderStatusChangeException(String message) {
        super(message);
    }
}
