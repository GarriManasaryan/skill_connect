package com.freelance.skc.port.adapters.backoffice.model.product.category;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record ProductCategoryBackofficeModel(
        @NotNull String id,
        @NotNull String name,
        @Nullable String description,
        @Nullable String parentId
) implements BaseBackofficeModel {
}
