package com.freelance.skc.port.adapters.backoffice.model.user;

import com.freelance.skc.domain.user.Role;
import com.freelance.skc.domain.user.UserDiscriminator;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record UserBackofficeModel(
        @NotNull String id,
        @NotNull String name,
        @NotNull String email,
        @NotNull Role role,
        @NotNull Integer age,
        @NotNull UserDiscriminator discriminator,
        @NotNull String timeZone
) implements BaseBackofficeModel {
}
