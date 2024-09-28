package com.freelance.skc.port.adapters.persistence.models.product;

import org.springframework.stereotype.Component;

@Component
public class CategorySQLModel {

    public static final String table = "sc_categories";

    public static final String idCol = "id";
    public static final String nameCol = "name";
    public static final String descriptionCol = "description";
    public static final String parentIdCol = "parent_id";
}
