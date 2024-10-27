package com.freelance.skc.domain.product;

import com.freelance.skc.application.common.IdGenerator;
import com.freelance.skc.application.common.validators.DomainInterface;
import com.freelance.skc.domain.product.price.Price;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public record Product(

        @NotNull String id,
        @NotNull String name,
        @NotNull Optional<String> description,
        @NotNull Price price,
        @NotNull String masterId,
        @NotNull List<String> categoryIds,
        @NotNull List<String> featureIds

    ) implements DomainInterface {

    public static Product of(
            @NotNull String name,
            @Nullable String description,
            @NotNull Price price,
            @NotNull String masterId,
            @NotNull List<String> categoryIds,
            @NotNull List<String> featureIds
    ){
        return new Product(
                IdGenerator.generate("prd"),
                name,
                Optional.ofNullable(description),
                price,
                masterId,
                categoryIds,
                featureIds
        );
    }

    public Product update(
            @NotNull String name,
            @Nullable String description,
            @NotNull Price price,
            @NotNull String masterId,
            @NotNull List<String> categoryIds,
            @NotNull List<String> featureIds
    ){
        return new Product(
                this.id,
                name,
                Optional.ofNullable(description),
                price,
                masterId,
                categoryIds,
                featureIds
        );
    }



}
