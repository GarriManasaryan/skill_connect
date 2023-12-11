package com.freelance.skc.domain.skill;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Skill(
        @NotNull String id,
        @NotNull String name,
        @NotNull String description,
        @Nullable String parentId
) implements DomainInterface {

    public static Skill of(
            @NotNull String name,
            @NotNull String description,
            @Nullable String parentId
    ) {
        return new Skill(
                IdGenerator.generate("skl"),
                name,
                description,
                parentId
        );
    }

}
