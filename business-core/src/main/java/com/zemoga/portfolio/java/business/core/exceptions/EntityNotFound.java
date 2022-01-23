package com.zemoga.portfolio.java.business.core.exceptions;

import lombok.Data;

@Data
public class EntityNotFound extends RuntimeException {

    private Class<?> entityClass;
    private Object entityId;

    public EntityNotFound(Class<?> entityClass, Object entityId) {
        super(String.format("Entity with id <%s> not found for the type <%s>",
                entityId, entityClass.getSimpleName()));
    }
}
