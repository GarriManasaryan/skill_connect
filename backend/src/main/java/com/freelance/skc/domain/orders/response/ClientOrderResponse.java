package com.freelance.skc.domain.orders.response;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ClientOrderResponse(
        @NotNull String id,
        @NotNull String profileId,
        @NotNull ClientOrderResponseStatus clientOrderResponseStatus,
        @NotNull OffsetDateTime appliedAt,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) implements DomainInterface {
    public static ClientOrderResponse of(
            @NotNull String profileId,
            @NotNull String applicationText,
            @NotNull String clientOrderId
    ){
        return new ClientOrderResponse(
                IdGenerator.generate("cor"),
                profileId,
                ClientOrderResponseStatus.PENDING,
                OffsetDateTime.now(),
                applicationText,
                clientOrderId
        );
    }
}
