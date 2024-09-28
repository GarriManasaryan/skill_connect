package com.freelance.skc.port.adapters.persistence.models.product;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoriesSQLModel implements BaseListSQLModel {

    public static final String table = "sc_product_categories";

    public static final String productIdCol = "product_id";
    public static final String categoryIdCol = "category_id";

    @Override
    public @NotNull String mainIdCol() {
        return productIdCol;
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