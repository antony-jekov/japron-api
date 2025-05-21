package io.jekov.japron.shared.error;


public class InvalidInputData extends AppError {

    public InvalidInputData(String propertyName, String reason) {
        super(propertyName, reason);
    }

}