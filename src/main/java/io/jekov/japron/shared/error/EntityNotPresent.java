package io.jekov.japron.shared.error;


public class EntityNotPresent extends AppError {

    public EntityNotPresent(String entityName) {
        super(entityName, "notPresent");
    }

}