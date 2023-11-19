package com.freelance.skc.port.adapters.backoffice.model.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record FreelanceServiceBackofficeModel(
        @NotNull String id,
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) {
}
