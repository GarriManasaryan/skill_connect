package com.freelance.skc.port.adapters.backoffice.model.orders.assignment;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public record OrderAssignmentUpdateRequest(
        @NotNull String clientId,
        @NotNull String profileId,
        @Nullable OffsetDateTime startAt,
        @Nullable OffsetDateTime endAt
) implements BaseUpdateRequest {
}
