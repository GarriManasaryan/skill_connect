package com.freelance.skc.port.adapters.backoffice.model.user;

import com.freelance.skc.domain.user.Role;
import com.freelance.skc.domain.user.UserDiscriminator;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public record UserCreationRequest(
        @NotNull String name,
        @NotNull String email,
        @NotNull Role role,
        @NotNull Integer age,
        @NotNull String discriminator
) {
}
