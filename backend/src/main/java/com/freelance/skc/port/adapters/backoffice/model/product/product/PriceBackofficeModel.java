package com.freelance.skc.port.adapters.backoffice.model.product.product;

import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public record PriceBackofficeModel(
        @NotNull Double value,
        @NotNull String currency,
        @Nullable Double discount
) {

}
