package io.jekov.japron.shared.error;

public abstract class AppError extends Exception {

    public AppError(String subject, String reason) {
        super("%s:%s".formatted(subject, reason));
    }

    public AppError(String subject, String reason, Throwable cause) {
        super("%s:%s".formatted(subject, reason), cause);
    }

}
