package com.freelance.skc.port.adapters.backoffice.model.orders.response;

import com.freelance.skc.domain.orders.response.ClientOrderResponseStatus;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ClientOrderResponseUpdateRequest(
        @NotNull String profileId,
        @NotNull ClientOrderResponseStatus clientOrderResponseStatus,
        @NotNull OffsetDateTime appliedAt,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) implements BaseUpdateRequest {

}
