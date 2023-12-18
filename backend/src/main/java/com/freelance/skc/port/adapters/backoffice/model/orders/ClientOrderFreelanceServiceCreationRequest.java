package com.freelance.skc.port.adapters.backoffice.model.orders;

import org.jetbrains.annotations.NotNull;

public record ClientOrderFreelanceServiceCreationRequest(
        @NotNull String clientOrderId,
        @NotNull String serviceId
) {
}
