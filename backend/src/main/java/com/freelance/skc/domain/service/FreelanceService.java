package com.freelance.skc.domain.service;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validation.DomainIntV2;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record FreelanceService(
        @NotNull String id,
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) implements DomainIntV2 {

    public static FreelanceService of(
            @NotNull String name,
            @NotNull String description,
            @Nullable String parentId
    ) {
        return new FreelanceService(
                IdGenerator.generate("srv"),
                name,
                description,
                parentId
        );
    }

}
