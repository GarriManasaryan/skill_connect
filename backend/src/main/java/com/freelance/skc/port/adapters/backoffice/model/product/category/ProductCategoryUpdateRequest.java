package com.freelance.skc.port.adapters.backoffice.model.product.category;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

public record ProductCategoryUpdateRequest(
        @NotNull String name,
        @Nullable String description,
        @Nullable String parentId
) implements BaseUpdateRequest {
}
