package com.gaurav.demo.web;

import com.gaurav.demo.exception.FeatureNotEnabledException;
import com.gaurav.demo.exception.HashNotFoundException;
import com.gaurav.demo.model.ErrorDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
    @Value("${errorMessage}")
    String errorMessage;
    @ExceptionHandler(HashNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleHashNotFoundException(HashNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(errorMessage);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(FeatureNotEnabledException.class)
    public final ResponseEntity<ErrorDetails> handleFeatureNotEnabledException(FeatureNotEnabledException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("Feature is not enabled");
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);

    }
}
