package com.freelance.skc.port.adapters.persistence.models.product.feature;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class FeatureCategoriesSQLModel implements BaseListSQLModel {

    public static final String table = "sc_feature_categories";

    public static final String featureIdCol = "feature_id";
    public static final String categoryIdCol = "category_id";

    @Override
    public @NotNull String mainIdCol() {
        return featureIdCol;
    }

    @Override
    public @NotNull String valuesIdCol() {
        return categoryIdCol;
    }

    @Override
    public @NotNull String table() {
        return table;
    }
}