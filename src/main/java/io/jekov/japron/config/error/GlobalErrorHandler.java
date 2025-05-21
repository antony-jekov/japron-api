package io.jekov.japron.config.error;

import io.jekov.japron.shared.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(AppError.class)
    ProblemDetail handleAppError(AppError error) {
        final var status = switch (error) {
            case EntityNotPresent ignored -> HttpStatus.NOT_FOUND;
            case EntityAlreadyPresent ignored -> HttpStatus.CONFLICT;
            case InvalidOperation ignored -> HttpStatus.NOT_ACCEPTABLE;
            case InvalidInputData ignored -> HttpStatus.BAD_REQUEST;
            case ServerError ignored -> HttpStatus.INTERNAL_SERVER_ERROR;

            default -> throw new IllegalArgumentException("unknown error");
        };

        return ProblemDetail.forStatusAndDetail(status, error.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    ProblemDetail handleNoResourceFoundException(NoResourceFoundException ignored) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "entity:notPresent");
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    ProblemDetail handleAuthorizationDeniedException(AuthorizationDeniedException ignored) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "access:notAuthorized");
    }

    @ExceptionHandler(Exception.class)
    ProblemDetail handleException(Exception ignored) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "server:internalError");
    }

}