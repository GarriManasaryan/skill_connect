package com.freelance.skc.application.common.validators;

import jakarta.validation.constraints.NotNull;

public interface DomainInterface {

    @NotNull String id();

}
