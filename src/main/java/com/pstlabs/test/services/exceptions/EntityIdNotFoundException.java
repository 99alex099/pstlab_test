package com.pstlabs.test.services.exceptions;

import com.pstlabs.test.dto.ExceptionDTO;
import lombok.Getter;

public class EntityIdNotFoundException extends RuntimeException {

    @Getter
    private ExceptionDTO exceptionDTO;

    public EntityIdNotFoundException(Long id) {
        super("id '" + id + "' is incorrect");
        this.exceptionDTO = new ExceptionDTO(this.getMessage());
    }
}
