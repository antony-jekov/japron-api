package io.jekov.japron.shared;

import io.jekov.japron.shared.error.AppError;
import jakarta.validation.Valid;


public interface CommandHandler<TCommand, TResult> {

    TResult handle(@Valid TCommand cmd) throws AppError;

}
