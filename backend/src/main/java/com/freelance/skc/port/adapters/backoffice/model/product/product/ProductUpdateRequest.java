package com.freelance.skc.port.adapters.backoffice.model.product.product;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record ProductUpdateRequest(
        @NotNull String name,
        @Nullable String description,
        @NotNull PriceBackofficeModel price,
        @NotNull String masterId,
        @NotNull List<String> categoryIds,
        @NotNull List<String> featureIds
) implements BaseUpdateRequest {
}
