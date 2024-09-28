package com.freelance.skc.domain.profile;

import com.freelance.skc.application.common.IdGenerator;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record Profile(
        @NotNull String id,
        @NotNull String title,
        @NotNull String description,
        @NotNull String userId,
        @NotNull List<String> skillIds,
        @NotNull List<String> serviceIds
) implements ProfileBase {
    public static Profile of(
            @NotNull String title,
            @NotNull String description,
            @NotNull String userId,
            @NotNull List<String> skillIds,
            @NotNull List<String> serviceIds
    ) {
        return new Profile(
                IdGenerator.generate("prf"),
                title,
                description,
                userId,
                skillIds,
                serviceIds
        );
    }

}
