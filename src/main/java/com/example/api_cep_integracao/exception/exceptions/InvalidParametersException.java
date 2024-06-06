package com.example.api_cep_integracao.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidParametersException extends RuntimeException{
    public InvalidParametersException(String message){
        super(message);
    }
}
