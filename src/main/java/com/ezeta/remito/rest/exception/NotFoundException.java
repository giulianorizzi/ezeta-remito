package com.ezeta.remito.rest.exception;

import com.ezeta.remito.rest.enums.Discriminator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public <T> NotFoundException(Class<T> clazz, Discriminator discriminator, String value) {
        super(String.format("%s with %s %s not found", clazz.getSimpleName(), discriminator, value));
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
