package io.jekov.japron.shared.error;


public class InvalidOperation extends AppError {

    public InvalidOperation(String operationName, String reason) {
        super(operationName, reason);
    }

}
