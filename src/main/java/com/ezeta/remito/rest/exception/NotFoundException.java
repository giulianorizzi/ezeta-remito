package com.ezeta.remito.rest.exception;

import com.ezeta.remito.rest.enums.Discriminator;

public class NotFoundException extends RuntimeException {
    public <T> NotFoundException(Class<T> clazz, Discriminator discriminator, String value) {
        super(String.format("%s with %s %s not found", clazz.getName(), discriminator, value));
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable error) {
        super(message, error);
    }
}
