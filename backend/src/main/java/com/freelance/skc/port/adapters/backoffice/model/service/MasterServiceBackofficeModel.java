package com.freelance.skc.port.adapters.backoffice.model.service;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record MasterServiceBackofficeModel(
        @NotNull String id,
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) implements BaseBackofficeModel {
}
