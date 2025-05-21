package io.jekov.japron.shared.error;


public class EntityAlreadyPresent extends AppError {

    public EntityAlreadyPresent(String entityName) {
        super(entityName, "alreadyPresent");
    }

}

