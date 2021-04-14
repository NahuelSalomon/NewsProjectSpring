package com.utn.NewsProject.Exceptions;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handlerConstraintViolationException(ConstraintViolationException ex, WebRequest request) {

        List<String> errors = new ArrayList<>();

        for(ConstraintViolation v : ex.getConstraintViolations()) {
            errors.add(v.getRootBeanClass()+" "+v.getMessage());
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),errors);

        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getHttpStatus());
    }

    public <E extends Exception> ResponseEntity<Object> handlerExceptions(E ex, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),errors);

        return new ResponseEntity<Object>(apiError,new HttpHeaders(),apiError.getHttpStatus());
    }

    @ExceptionHandler({NewsNotFoundException.class})
    public ResponseEntity<Object> handlerNewsNotFoundException(NewsNotFoundException ex, WebRequest request) {
        return handlerExceptions(ex,request);
    }

    @ExceptionHandler({OwerNotFoundException.class})
    public ResponseEntity<Object> handlerOwerNotFoundException(OwerNotFoundException ex, WebRequest request) {
        return handlerExceptions(ex,request);
    }

    @ExceptionHandler({IdentifierGenerationException.class})
    public ResponseEntity<Object> handlerIdentifierGenerationException(IdentifierGenerationException ex, WebRequest request) {
        return handlerExceptions(ex,request);
    }
}
