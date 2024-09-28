package com.freelance.skc.port.adapters.backoffice.model.service;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record MasterServiceUpdateRequest(
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) implements BaseUpdateRequest {
}
