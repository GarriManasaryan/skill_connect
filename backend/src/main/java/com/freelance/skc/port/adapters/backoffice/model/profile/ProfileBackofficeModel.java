package com.freelance.skc.port.adapters.backoffice.model.profile;

import org.jetbrains.annotations.NotNull;

public record ProfileBackofficeModel(
        @NotNull String id,
        @NotNull String title,
        @NotNull String description,
        byte[] sellerPic,
        @NotNull String userId
) {
}
