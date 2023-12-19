package com.freelance.skc.port.adapters.backoffice.model.profile;

import org.jetbrains.annotations.NotNull;

public record ProfileCreationRequest(
        @NotNull String title,
        @NotNull String description,
        byte[] sellerPic,
        @NotNull String userId
) {
}
