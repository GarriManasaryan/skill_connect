package com.freelance.skc.domain.product.feature;

import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public sealed interface FeatureBase extends DomainInterface permits FeatureText, FeatureNumeric {
    // + categorical
    @NotNull String name();
    @NotNull Optional<String> description();
    @NotNull Optional<String> parentId();
    @NotNull List<String> categoryIds();
    @NotNull FeatureDiscriminator discriminator();
}
