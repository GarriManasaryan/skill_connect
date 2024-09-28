package com.freelance.skc.port.adapters.persistence.models.common;

import jakarta.validation.constraints.NotNull;

public interface BaseListSQLModel {

    @NotNull
    String table();

    @NotNull
    String mainIdCol();

    @NotNull
    String valuesIdCol();
}
