package com.freelance.skc.port.adapters.backoffice.model.orders.client;

import com.freelance.skc.domain.orders.client.ClientOrderStatus;
import com.freelance.skc.domain.orders.client.OrderType;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

public record ClientOrderBackofficeModel(
        @NotNull String id,
        @NotNull String clientId,
        @NotNull String title,
        @NotNull String description,
        @NotNull List<String> serviceIds,
        @NotNull OrderType orderType,
        @NotNull ClientOrderStatus status,
        @Nullable OffsetDateTime endAt
) implements BaseBackofficeModel {
}
