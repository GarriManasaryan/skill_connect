package com.freelance.skc.port.adapters.persistence.models.profile;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProfileSkillsSQLModel implements BaseListSQLModel {

    public static final String table = "sc_profile_skills";

    public static final String profileIdCol = "profile_id";
    public static final String skillIdCol = "skill_id";

    @Override
    public @NotNull String mainIdCol() {
        return profileIdCol;
    }

    @Override
    public @NotNull String valuesIdCol() {
        return skillIdCol;
    }

    @Override
    public @NotNull String table() {
        return table;
    }
}