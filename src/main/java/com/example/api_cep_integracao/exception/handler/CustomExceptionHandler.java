package com.example.api_cep_integracao.exception.handler;

import com.example.api_cep_integracao.exception.error.ErrorMessage;
import com.example.api_cep_integracao.exception.exceptions.InvalidParametersException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidParametersException.class)
    public ErrorMessage handleInvalidParametersException(InvalidParametersException ex) {
        return new ErrorMessage(ex.getMessage());
    }

}
