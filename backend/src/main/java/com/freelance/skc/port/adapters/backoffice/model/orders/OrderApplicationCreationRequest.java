package com.freelance.skc.port.adapters.backoffice.model.orders;

import com.freelance.skc.domain.orders.OrderApplicationStatus;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public record OrderApplicationCreationRequest(
        @NotNull String profileId,
        @NotNull String orderApplicationStatus,
        @NotNull OffsetDateTime appliedAt,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) {
}
