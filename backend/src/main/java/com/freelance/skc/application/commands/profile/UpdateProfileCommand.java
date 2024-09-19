package com.freelance.skc.application.commands.profile;

import org.jetbrains.annotations.NotNull;

public sealed interface UpdateProfileCommand permits UpdateProfileDescription, UpdateProfileTitle, UpdateProfileUserId{
    @NotNull String profileId();
}
