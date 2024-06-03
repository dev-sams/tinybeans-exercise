package com.tinybeans.backend.evaluation.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message)
    {
        super(message);
    }
}
