package com.example.devapo.githubapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SupportingErrorAdvice {


    @ResponseBody
    @ExceptionHandler(SupportingError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RuntimeErrorHandler(SupportingError ex){
        return ex.getMessage();
    }

}
