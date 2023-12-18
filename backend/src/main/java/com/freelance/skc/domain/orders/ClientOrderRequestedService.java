package com.freelance.skc.domain.orders;

import org.jetbrains.annotations.NotNull;

public record ClientOrderRequestedService(
        @NotNull String clientOrderId,
        @NotNull String serviceId
) {
}
