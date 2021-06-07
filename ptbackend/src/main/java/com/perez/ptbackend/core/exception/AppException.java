package com.perez.ptbackend.core.exception;

public class AppException extends BaseException {

    public AppException(String message, Throwable t) {
        super("AplicationError", message, t);
    }

    public AppException(String message) {
        super("AplicationError", message);
    }

    private static final long serialVersionUID = 235466712L;



}
