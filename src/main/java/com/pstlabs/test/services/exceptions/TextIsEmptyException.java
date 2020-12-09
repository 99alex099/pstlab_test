package com.pstlabs.test.services.exceptions;

import com.pstlabs.test.dto.ExceptionDTO;
import lombok.Getter;

public class TextIsEmptyException extends RuntimeException {
    @Getter
    private ExceptionDTO exceptionDTO;

    public TextIsEmptyException(String text) {
        super("text '" + text + "' is empty");
        this.exceptionDTO = new ExceptionDTO(this.getMessage());
    }

    public TextIsEmptyException() {
        super("invalid data (not all fields were filled)");
        this.exceptionDTO = new ExceptionDTO(this.getMessage());
    }
}
