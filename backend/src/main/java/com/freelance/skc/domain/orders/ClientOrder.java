package com.freelance.skc.domain.orders;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public record ClientOrder(
        @NotNull String id,
        @NotNull String clientId,
        @NotNull String title,
        @NotNull String description,
        @NotNull OrderType orderType,
        @Nullable OffsetDateTime endAt
) implements DomainInterface {
    public static ClientOrder of(
            @NotNull String clientId,
            @NotNull String title,
            @NotNull String description,
            @NotNull OrderType orderType,
            @Nullable OffsetDateTime endAt
    ) {
        return new ClientOrder(
                IdGenerator.generate("clo"),
                clientId,
                title,
                description,
                orderType,
                endAt
        );
    }
}
