package com.freelance.skc.port.adapters.backoffice.model.common;

import jakarta.validation.constraints.NotNull;

public interface BaseBackofficeModel {

    @NotNull String id();

}
