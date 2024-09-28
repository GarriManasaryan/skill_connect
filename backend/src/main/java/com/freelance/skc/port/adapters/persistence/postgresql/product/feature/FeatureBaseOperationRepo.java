package com.freelance.skc.port.adapters.persistence.postgresql.product.feature;

import com.freelance.skc.domain.product.feature.FeatureBase;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureBaseSQLModel;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class FeatureBaseOperationRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public FeatureBaseOperationRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo, JsonOperations jsonOperations) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
        this.jsonOperations = jsonOperations;
    }

    public JdbcPostgresExecuterRepo jdbcPostgresExecuter() {
        return jdbcPostgresExecuterRepo;
    }

    public JsonOperations jsonOperationsExecuter() {
        return jsonOperations;
    }

    public static String getFeatureCategoryIdsQuery() {
        return """
                WITH feature_categories AS (
                    SELECT fc.feature_id AS id, jsonb_agg(category_id) AS category_ids 
                    FROM sc_feature_categories fc 
                    GROUP BY fc.feature_id
                )
                """;
    }

    public static String getFeatureBaseQueryWithJoin() {
        return """
                SELECT fb.*, fspec.*, COALESCE(fc.category_ids, '[]'::jsonb) AS feature_categories 
                FROM sc_features fb
                LEFT JOIN sc_features_discriminator fspec ON fb.id = fspec.id
                LEFT JOIN feature_categories fc ON fb.id = fc.id
                WHERE fb.discriminator = 'FEATURE_DISCRIMINATOR'
                """;
    }

    public void saveFeatureBase(FeatureBase domain) {
        var sqlTemplate = MessageFormat.format("""
                INSERT INTO {0} 
                ({1}, {2}, {3}, {4}, {5})
                VALUES
                (:{1}, :{2}, :{3}, :{4}, :{5})
                """, FeatureBaseSQLModel.table,
                FeatureBaseSQLModel.idCol, FeatureBaseSQLModel.nameCol, FeatureBaseSQLModel.descriptionCol, FeatureBaseSQLModel.parentIdCol, FeatureBaseSQLModel.discriminatorCol);

        var params = new MapSqlParameterSource()
                .addValue(FeatureBaseSQLModel.idCol, domain.id())
                .addValue(FeatureBaseSQLModel.nameCol, domain.name())
                .addValue(FeatureBaseSQLModel.descriptionCol, domain.description().orElse(null))
                .addValue(FeatureBaseSQLModel.parentIdCol, domain.parentId().orElse(null))
                .addValue(FeatureBaseSQLModel.discriminatorCol, domain.discriminator().name())
                ;

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
    }


}
