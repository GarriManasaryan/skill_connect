package com.freelance.skc.domain.orders.client;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

public record ClientOrder(
        @NotNull String id,
        @NotNull String clientId,
        @NotNull String title,
        @NotNull String description,
        @NotNull List<String> serviceIds,
        @NotNull OrderType orderType,
        @NotNull ClientOrderStatus status,
        @Nullable OffsetDateTime endAt
) implements DomainInterface {

    public static ClientOrder of(
            @NotNull String clientId,
            @NotNull String title,
            @NotNull String description,
            @NotNull List<String> serviceIds,
            @NotNull OrderType orderType,
            @Nullable OffsetDateTime endAt
    ) {
        return new ClientOrder(
                IdGenerator.generate("clo"),
                clientId,
                title,
                description,
                serviceIds,
                orderType,
                ClientOrderStatus.OPEN,
                endAt
        );
    }
}
