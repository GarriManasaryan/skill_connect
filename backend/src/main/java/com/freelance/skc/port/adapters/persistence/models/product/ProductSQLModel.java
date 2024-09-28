package com.freelance.skc.port.adapters.persistence.models.product;

import org.springframework.stereotype.Component;

@Component
public class ProductSQLModel {

    public static final String table = "sc_products";

    public static final String idCol = "id";
    public static final String nameCol = "name";
    public static final String descriptionCol = "description";
    public static final String priceCol = "price";
    public static final String masterIdCol = "master_id";
}
