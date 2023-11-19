package com.freelance.skc.port.adapters.backoffice.model.orders;

import com.freelance.skc.domain.orders.OrderType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public record ClientOrderCreationRequest(
        @NotNull String clientId,
        @NotNull String title,
        @NotNull String description,
        @NotNull String serviceId,
        @NotNull String orderType,
        @Nullable OffsetDateTime endAt
) {
}
