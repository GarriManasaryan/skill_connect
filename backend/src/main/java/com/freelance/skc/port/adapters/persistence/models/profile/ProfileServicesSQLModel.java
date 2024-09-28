package com.freelance.skc.port.adapters.persistence.models.profile;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProfileServicesSQLModel implements BaseListSQLModel {

    public static final String table = "sc_profile_services";

    public static final String profileIdCol = "profile_id";
    public static final String serviceIdCol = "service_id";

    @Override
    public @NotNull String mainIdCol() {
        return profileIdCol;
    }

    @Override
    public @NotNull String valuesIdCol() {
        return serviceIdCol;
    }

    @Override
    public @NotNull String table() {
        return table;
    }
}