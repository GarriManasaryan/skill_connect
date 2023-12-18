package com.freelance.skc.port.adapters.backoffice.model.orders;

import com.freelance.skc.domain.orders.OrderType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public record ClientOrderFreelanceServiceBackofficeModel(
        @NotNull String clientOrderId,
        @NotNull String serviceId
) {
}
