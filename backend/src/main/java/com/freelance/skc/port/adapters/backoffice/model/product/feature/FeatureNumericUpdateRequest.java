package com.freelance.skc.port.adapters.backoffice.model.product.feature;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record FeatureNumericUpdateRequest(
        @NotNull String name,
        @Nullable String description,
        @Nullable String parentId,
        @NotNull List<String> categoryIds,
        @NotNull Double from,
        @Nullable Double to,
        @Nullable String unit,
        @Nullable String lessThanText,
        @Nullable String moreThanText
) implements BaseUpdateRequest {
}
