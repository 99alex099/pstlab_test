package com.pstlabs.test.services.interfaces;

import com.pstlabs.test.entities.Student;
import com.pstlabs.test.services.exceptions.EntityIdNotFoundException;
import com.pstlabs.test.services.exceptions.TextIsEmptyException;

public interface EntityService<Entity> {
    Iterable<Entity> findAll();
    Entity findById(Long id) throws EntityIdNotFoundException;
    Entity addEntity(Entity entity) throws TextIsEmptyException;
    Entity updateEntity(Entity entity) throws TextIsEmptyException;
    void deleteEntity(Long id) throws EntityIdNotFoundException;
}
