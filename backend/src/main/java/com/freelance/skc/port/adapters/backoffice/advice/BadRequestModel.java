package com.freelance.skc.port.adapters.backoffice.advice;

import jakarta.validation.constraints.NotNull;

public record BadRequestModel(
        @NotNull String message
) {
}
