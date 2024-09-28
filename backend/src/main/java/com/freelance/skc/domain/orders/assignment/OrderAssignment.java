package com.freelance.skc.domain.orders.assignment;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Optional;

public record OrderAssignment(
        @NotNull String id,
        @NotNull String clientId,
        @NotNull String profileId,
        @NotNull Optional<OffsetDateTime> startAt,
        @NotNull Optional<OffsetDateTime> endAt
) implements DomainInterface {

    public static OrderAssignment of(
            @NotNull String clientId,
            @NotNull String profileId,
            @Nullable OffsetDateTime startAt,
            @Nullable OffsetDateTime endAt
    ) {
        return new OrderAssignment(
                IdGenerator.generate("oas"),
                clientId,
                profileId,
                Optional.ofNullable(startAt),
                Optional.ofNullable(endAt)
        );
    }

}
