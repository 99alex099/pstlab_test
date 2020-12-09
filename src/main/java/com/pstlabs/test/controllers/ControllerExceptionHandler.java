package com.pstlabs.test.controllers;

import com.pstlabs.test.dto.ExceptionDTO;
import com.pstlabs.test.services.exceptions.EntityIdNotFoundException;
import com.pstlabs.test.services.exceptions.TextIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionDTO idNotFound(final EntityIdNotFoundException e) {
        return e.getExceptionDTO();
    }

    @ExceptionHandler(TextIsEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionDTO invalidText(final TextIsEmptyException e) {
        return e.getExceptionDTO();
    }
}
