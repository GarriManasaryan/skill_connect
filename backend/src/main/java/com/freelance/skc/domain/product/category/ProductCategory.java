package com.freelance.skc.domain.product.category;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record ProductCategory(
        @NotNull String id,
        @NotNull String name,
        @Nullable String description,
        @Nullable String parentId
) implements DomainInterface {

    public static ProductCategory of(
            @NotNull String name,
            @Nullable String description,
            @Nullable String parentId
    ){
        return new ProductCategory(
                IdGenerator.generate("pct"),
                name,
                description,
                parentId
        );
    }
}
