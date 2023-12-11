package com.freelance.skc.port.adapters.backoffice.model.skill;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record SkillCreationRequest(
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) {
}
