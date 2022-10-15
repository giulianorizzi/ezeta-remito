package com.ezeta.remito.rest.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {
    private final String ERROR_MESSAGE = "Validation Error";

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public InvalidArgumentError methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return processFieldErrors(result.getFieldErrors());
    }

    private InvalidArgumentError processFieldErrors(List<FieldError> fieldErrors) {
        InvalidArgumentError error = new InvalidArgumentError(BAD_REQUEST.value(), ERROR_MESSAGE);
        fieldErrors.forEach(error::addFieldError);
        return error;
    }
}