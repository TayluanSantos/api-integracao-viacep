package com.example.api_cep_integracao.exception.handler;

import com.example.api_cep_integracao.exception.error.ErrorMessage;
import com.example.api_cep_integracao.exception.exceptions.InvalidParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidParametersException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidParametersException(InvalidParametersException ex) {
        return new ErrorMessage(ex.getMessage());
    }

}
