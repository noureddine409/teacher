package com.example.demo.exception;


public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException() {
        super();
    }

    public ElementAlreadyExistsException(String message) {
        super(message);
    }

    public ElementAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ElementAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
