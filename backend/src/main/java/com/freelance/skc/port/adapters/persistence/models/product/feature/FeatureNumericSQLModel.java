package com.freelance.skc.port.adapters.persistence.models.product.feature;

import org.springframework.stereotype.Component;

@Component
public class FeatureNumericSQLModel {

    public static final String table = "sc_features_numeric";

    public static final String idCol = "id";
    public static final String fromValueCol = "from_value";
    public static final String toValueCol = "to_value";
    public static final String unitCol = "unit";
    public static final String lessThanTextId = "less_than_text";
    public static final String moreThanTextId = "more_than_text";
}
