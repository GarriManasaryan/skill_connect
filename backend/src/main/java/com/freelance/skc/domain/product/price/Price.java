package com.freelance.skc.domain.product.price;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record Price(
        @NotNull Double value,
        @NotNull String currency,
        @NotNull Optional<Double> discount
) {

}
