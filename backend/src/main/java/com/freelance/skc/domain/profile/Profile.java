package com.freelance.skc.domain.profile;

import com.freelance.skc.application.IdGenerator;
import org.jetbrains.annotations.NotNull;

public record Profile(
        @NotNull String id,
        @NotNull String title,
        @NotNull String description,
        @NotNull String userId
) {
    public static Profile of(
            @NotNull String title,
            @NotNull String description,
            @NotNull String userId
    ) {
        return new Profile(
                IdGenerator.generate("prf"),
                title,
                description,
                userId
        );
    }
}
