package com.freelance.skc.port.adapters.backoffice.model.profile;

import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public record ProfileUpdateRequest(
        @NotNull String title,
        @NotNull String description,
        @NotNull String userId,
        @NotNull List<String> skillIds,
        @NotNull List<String> serviceIds
) implements BaseUpdateRequest {

}
