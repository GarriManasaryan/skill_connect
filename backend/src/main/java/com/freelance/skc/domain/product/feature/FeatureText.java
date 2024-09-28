package com.freelance.skc.domain.product.feature;

import com.freelance.skc.application.common.IdGenerator;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public record FeatureText(
        @NotNull String id,
        @NotNull String name,
        @NotNull Optional<String> description,
        @NotNull Optional<String> parentId,
        @NotNull List<String> categoryIds,
        @NotNull String value
) implements FeatureBase {

    @Override
    public @NotNull FeatureDiscriminator discriminator() {
        return FeatureDiscriminator.FEATURE_TEXT;
    }

    public static FeatureText of(
            @NotNull String name,
            @Nullable String description,
            @Nullable String parentId,
            @NotNull List<String> categoryIds,
            @NotNull String value

    ){
        return new FeatureText(
                IdGenerator.generate("ftt"),
                name,
                Optional.ofNullable(description),
                Optional.ofNullable(parentId),
                categoryIds,
                value
        );
    }

}
