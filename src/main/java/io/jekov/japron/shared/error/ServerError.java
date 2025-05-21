package io.jekov.japron.shared.error;

public class ServerError extends AppError {

    public ServerError() {
        this(null);
    }

    public ServerError(Throwable cause) {
        super("server", "internalError", cause);
    }

}
