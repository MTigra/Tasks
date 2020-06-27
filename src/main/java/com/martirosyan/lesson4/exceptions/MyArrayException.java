package com.martirosyan.lesson4.exceptions;

public class MyArrayException extends RuntimeException {

    public MyArrayException() {
    }

    public MyArrayException(String message) {
        super(message);
    }
}
