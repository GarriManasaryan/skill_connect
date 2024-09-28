package com.freelance.skc.port.adapters.persistence.postgresql.product;

import com.freelance.skc.domain.product.Product;
import com.freelance.skc.domain.product.ProductRepo;
import com.freelance.skc.domain.product.price.Price;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import static com.freelance.skc.port.adapters.persistence.models.product.ProductSQLModel.*;

import com.freelance.skc.port.adapters.persistence.models.product.ProductCategoriesSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.ProductFeaturesSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.ProductSQLModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresqlProductRepo implements ProductRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public PostgresqlProductRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo, JsonOperations jsonOperations) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
        this.jsonOperations = jsonOperations;
    }

    private RowMapper<Product> asProductRowMapper() {
        return (rs, rowNum) -> new Product(
                rs.getString(idCol),
                rs.getString(nameCol),
                Optional.ofNullable(rs.getString(descriptionCol)),
                jsonOperations.asEntityRowMapper(rs.getString(priceCol), Price.class),
                rs.getString(masterIdCol),
                jsonOperations.deserializeFromStringToListJson(rs.getString("product_category_ids")),
                jsonOperations.deserializeFromStringToListJson(rs.getString("product_feature_ids"))

        );
    }

    @Override
    public void save(Product product) {
        // product
        saveProduct(product);

        // product categories
        jdbcPostgresExecuterRepo.updateEntityListValues(product.id(), product.categoryIds(), new ProductCategoriesSQLModel());

        // product features
        jdbcPostgresExecuterRepo.updateEntityListValues(product.id(), product.featureIds(), new ProductFeaturesSQLModel());
    }

    private void saveProduct(Product product){
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5})
                values
                (:{1}, :{2}, :{3}, :{4}::jsonb, :{5})
                """, table,
                idCol, nameCol, descriptionCol, priceCol, masterIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, product.id())
                .addValue(nameCol, product.name())
                .addValue(descriptionCol, product.description().orElse(null))
                .addValue(priceCol, jsonOperations.serializeFromObjToStringJson(product.price()))
                .addValue(masterIdCol, product.masterId())
                ;

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
    }


    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public List<Product> all() {
        return jdbcPostgresExecuterRepo.customQuery(query(), asProductRowMapper());
    }

    @Override
    public Optional<Product> ofId(String id) {
        return jdbcPostgresExecuterRepo.customQuery(query(id), asProductRowMapper()).stream().findFirst();
    }

    private static String baseQuery(){
        return """
                WITH product_features AS (
                    SELECT pf.product_id AS id, jsonb_agg(pf.feature_id) AS feature_ids
                    FROM sc_product_features pf
                    GROUP BY pf.product_id
                ),
                product_categories AS (
                    SELECT pc.product_id AS id, jsonb_agg(pc.category_id) AS category_ids
                    FROM sc_product_categories pc
                    GROUP BY pc.product_id
                )
                SELECT
                    p.*,
                    COALESCE(pfs.feature_ids, '[]'::jsonb) as product_feature_ids,
                    COALESCE(pcs.category_ids, '[]'::jsonb) as product_category_ids
                FROM sc_products p
                LEFT JOIN product_features pfs ON p.id = pfs.id
                LEFT JOIN product_categories pcs ON p.id = pcs.id
                """;
    }

    private static String query(){
        return baseQuery();
    }

    private static String query(String id){
        var sql = baseQuery();
        return sql + " where p.id = '" + id + "'";
    }

}
