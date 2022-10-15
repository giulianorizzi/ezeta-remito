package com.ezeta.remito.rest.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class InvalidArgumentError {
    private final int status;
    private final String message;
    private final List<FieldError> fieldErrors = new ArrayList<>();

    public InvalidArgumentError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void addFieldError(FieldError fieldError) {
        FieldError sanitizedError = new FieldError(
                fieldError.getObjectName(),
                fieldError.getField(),
                Objects.requireNonNull(fieldError.getDefaultMessage())
        );

        fieldErrors.add(sanitizedError);
    }
}