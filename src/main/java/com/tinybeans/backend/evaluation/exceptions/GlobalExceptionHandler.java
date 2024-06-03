package com.tinybeans.backend.evaluation.exceptions;

import com.tinybeans.backend.evaluation.dto.ResponseDTO;
import com.tinybeans.backend.evaluation.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO<Void> handleException(Exception exception) {
        return new ResponseDTO<>(null, Constants.STATUS_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO<Void> handleRuntimeException(RuntimeException exception) {
        return new ResponseDTO<>(null, Constants.STATUS_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseDTO<Void> handleGenericException(GenericException exception) {
        return new ResponseDTO<>(null, Constants.STATUS_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseDTO<Void> handleBadRequestException(BadRequestException exception){
        return new ResponseDTO<>(null, Constants.STATUS_BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(InvalidArgumentsException.class)
    public ResponseDTO<Void> handleInvalidArgumentsException(InvalidArgumentsException exception){
        return new ResponseDTO<>(null, Constants.STATUS_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseDTO<Void> handleUserNotFoundException(ResourceNotFoundException exception){
        return new ResponseDTO<>(null, Constants.STATUS_NOT_FOUND, exception.getMessage());
    }
}
