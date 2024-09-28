package com.freelance.skc.port.adapters.persistence.models.product.feature;

import org.springframework.stereotype.Component;

@Component
public class FeatureBaseSQLModel {

    public static final String table = "sc_features";

    public static final String idCol = "id";
    public static final String nameCol = "name";
    public static final String descriptionCol = "description";
    public static final String parentIdCol = "parent_id";
    public static final String discriminatorCol = "discriminator";
}
