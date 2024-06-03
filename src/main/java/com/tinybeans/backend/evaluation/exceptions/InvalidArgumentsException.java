package com.tinybeans.backend.evaluation.exceptions;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException(String message)
    {
        super(message);
    }
}
