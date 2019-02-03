package com.gaurav.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HashNotFoundException extends RuntimeException {
    String err_msg;

    public HashNotFoundException(String err_msg) {
        this.err_msg = err_msg;
    }
}
