package com.freelance.skc.port.adapters.backoffice.model.orders.response;

import com.freelance.skc.domain.orders.response.ClientOrderResponseStatus;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record ClientOrderResponseCreationRequest(
        @NotNull String profileId,
        @NotNull String applicationText,
        @NotNull String clientOrderId
) implements BaseCreationRequest {

}
