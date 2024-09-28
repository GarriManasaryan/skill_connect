package com.freelance.skc.port.adapters.backoffice.model.product.feature;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record FeatureTextCreationRequest(
        @NotNull String name,
        @Nullable String description,
        @Nullable String parentId,
        @NotNull List<String> categoryIds,
        @Nullable String value
) implements BaseCreationRequest {
}