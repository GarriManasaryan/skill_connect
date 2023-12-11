package com.freelance.skc.domain.orders;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public record OrderApplication(
        @NotNull String id,
        @NotNull String profileId,
        @NotNull OrderApplicationStatus orderApplicationStatus,
        @NotNull OffsetDateTime appliedAt,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) implements DomainInterface {
    public static OrderApplication of(
            @NotNull String profileId,
            @NotNull OrderApplicationStatus orderApplicationStatus,
            @NotNull OffsetDateTime appliedAt,
            @NotNull String applicationText,
            @NotNull String clientOrderId
    ){
        return new OrderApplication(
                IdGenerator.generate("oap"),
                profileId,
                orderApplicationStatus,
                appliedAt,
                applicationText,
                clientOrderId
        );
    }
}
