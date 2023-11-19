package com.freelance.skc.port.adapters.backoffice.model.orders;

import com.freelance.skc.domain.orders.OrderApplicationStatus;
import com.freelance.skc.domain.orders.OrderType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public record OrderApplicationBackofficeModel(
        @NotNull String id,
        @NotNull String profileId,
        @NotNull OrderApplicationStatus orderApplicationStatus,
        @NotNull OffsetDateTime appliedAt,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) {
}
