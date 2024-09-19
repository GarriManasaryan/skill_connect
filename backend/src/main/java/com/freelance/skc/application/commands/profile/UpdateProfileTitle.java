package com.freelance.skc.application.commands.profile;

import com.freelance.skc.application.commands.UpdateCommand;
import com.freelance.skc.domain.profile.Profile;
import org.jetbrains.annotations.NotNull;

public record UpdateProfileTitle(
        @NotNull String profileId,
        @NotNull String title
) implements UpdateProfileCommand {
    // холдер данных, а сам update и в service и в домене
}
