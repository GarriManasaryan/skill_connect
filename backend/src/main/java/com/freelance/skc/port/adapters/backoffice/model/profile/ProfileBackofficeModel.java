package com.freelance.skc.port.adapters.backoffice.model.profile;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProfileBackofficeModel(
        @NotNull String id,
        @NotNull String title,
        @NotNull String description,
        @NotNull String userId,
        @NotNull List<String> skillIds,
        @NotNull List<String> serviceIds
) implements BaseBackofficeModel {
}
