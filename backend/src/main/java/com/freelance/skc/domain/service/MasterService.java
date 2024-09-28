package com.freelance.skc.domain.service;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record MasterService(
        @NotNull String id,
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) implements DomainInterface {

    public static MasterService of(
            @NotNull String name,
            @NotNull String description,
            @Nullable String parentId
    ) {
        return new MasterService(
                IdGenerator.generate("srv"),
                name,
                description,
                parentId
        );
    }

}
