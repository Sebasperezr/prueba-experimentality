package com.perez.ptbackend.core.exception;

public class ValidationException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ValidationException(String code, String message) {
        super(code, message);
    }



}
