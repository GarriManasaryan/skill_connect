package com.freelance.skc.domain.profile;

import com.freelance.skc.application.common.validators.DomainInterface;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface ProfileBase extends DomainInterface {

    @NotNull String id();
    @NotNull String title();
    @NotNull String description();
    @NotNull String userId();
    @NotNull List<String> skillIds();
    @NotNull List<String> serviceIds();

}
