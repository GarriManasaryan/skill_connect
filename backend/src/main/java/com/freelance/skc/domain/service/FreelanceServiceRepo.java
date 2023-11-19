package com.freelance.skc.domain.service;

import com.freelance.skc.application.validation.DomainRepoIntV2;
import com.freelance.skc.application.validators.DomainInterface;
import com.freelance.skc.application.validators.DomainRepoInterface;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FreelanceServiceRepo extends DomainRepoIntV2 {

    @Override
    @NotNull List<String> allIds();

    void save(@NotNull FreelanceService freelanceService);

    void delete(@NotNull String id);

    @NotNull List<FreelanceService> all();

}
