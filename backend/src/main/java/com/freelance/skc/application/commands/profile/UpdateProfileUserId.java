package com.freelance.skc.application.commands.profile;

import org.jetbrains.annotations.NotNull;

public record UpdateProfileUserId(
        @NotNull String profileId,
        @NotNull String userId
) implements UpdateProfileCommand {
    // холдер данных, а сам update и в service и в домене
}
