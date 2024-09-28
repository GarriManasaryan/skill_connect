package com.freelance.skc.port.adapters.backoffice.model.profile;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProfileCreationRequest(
        @NotNull String title,
        @NotNull String description,
        @NotNull String userId,
        @NotNull List<String> skillIds,
        @NotNull List<String> serviceIds
) implements BaseCreationRequest {
}
