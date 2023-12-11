package com.freelance.skc.domain.user;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public record User(
        @NotNull String id,
        @NotNull String name,
        @NotNull String email,
        @NotNull Role role,
        @NotNull Integer age,
        @NotNull UserDiscriminator discriminator,
        @NotNull String timeZone
) implements DomainInterface {

    public static User of(
            @NotNull String name,
            @NotNull String email,
            @NotNull Role role,
            @NotNull Integer age,
            @NotNull UserDiscriminator discriminator,
            @NotNull String timeZone
    ) {
        return new User(
                IdGenerator.generate("usr"),
                name,
                email,
                role,
                age,
                discriminator,
                timeZone
        );
    }

}
