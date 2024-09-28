package com.freelance.skc.port.adapters.persistence.postgresql.product.feature;

import com.freelance.skc.domain.product.feature.FeatureDiscriminator;
import com.freelance.skc.domain.product.feature.FeatureText;
import com.freelance.skc.domain.product.feature.FeatureTextRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureCategoriesSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureTextSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureBaseSQLModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;


@Repository
public class PostgresqlFeatureTextRepo implements FeatureTextRepo {

    private final FeatureBaseOperationRepo featureBaseOperationRepo;
    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public PostgresqlFeatureTextRepo(FeatureBaseOperationRepo featureBaseOperationRepo) {
        this.featureBaseOperationRepo = featureBaseOperationRepo;
        this.jsonOperations = featureBaseOperationRepo.jsonOperationsExecuter();
        this.jdbcPostgresExecuterRepo = featureBaseOperationRepo.jdbcPostgresExecuter();
    }

    private RowMapper<FeatureText> asFeatureTextRowMapper() {
        return (rs, rowNum) -> new FeatureText(
                rs.getString(FeatureBaseSQLModel.idCol),
                rs.getString(FeatureBaseSQLModel.nameCol),
                Optional.ofNullable(rs.getString(FeatureBaseSQLModel.descriptionCol)),
                Optional.ofNullable(rs.getString(FeatureBaseSQLModel.parentIdCol)),
                jsonOperations.deserializeFromStringToListJson(rs.getString("feature_categories")),
                rs.getString(FeatureTextSQLModel.valueCol)

        );
    }

    @Override
    public List<FeatureText> all() {
        return jdbcPostgresExecuterRepo.customQuery(query(), asFeatureTextRowMapper());
    }

    @Override
    public void save(FeatureText domain) {
        // base feature
        featureBaseOperationRepo.saveFeatureBase(domain);
        // text feature
        saveFeatureText(domain);
        // categories
        jdbcPostgresExecuterRepo.updateEntityListValues(domain.id(), domain.categoryIds(), new FeatureCategoriesSQLModel());
    }

    private void saveFeatureText(FeatureText domain) {
        var sqlTemplate = MessageFormat.format("""
                INSERT INTO {0} 
                ({1}, {2})
                VALUES
                (:{1}, :{2})
                """, FeatureTextSQLModel.table,
                FeatureTextSQLModel.idCol, FeatureTextSQLModel.valueCol);

        var params = new MapSqlParameterSource()
                .addValue(FeatureTextSQLModel.idCol, domain.id())
                .addValue(FeatureTextSQLModel.valueCol, domain.value())
                ;

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
    }

    @Override
    public Optional<FeatureText> ofId(String id) {
        return jdbcPostgresExecuterRepo.customQuery(queryById(id), asFeatureTextRowMapper()).stream().findFirst();
    }

    @Override
    public void delete(String id) {
        // cascade удалит из дочерних таблиц также
        jdbcPostgresExecuterRepo.delete(FeatureBaseSQLModel.table, id);

    }

    private static String baseQuery() {
        var baseJoinQuery = FeatureBaseOperationRepo.getFeatureBaseQueryWithJoin()
                .replaceAll("sc_features_discriminator", FeatureTextSQLModel.table)
                .replaceAll("FEATURE_DISCRIMINATOR", FeatureDiscriminator.FEATURE_TEXT.name())
                ;
        var withCategoryIds = FeatureBaseOperationRepo.getFeatureCategoryIdsQuery();

        return withCategoryIds + baseJoinQuery;

    }

    private String query() {
        return baseQuery();
    }

    private String queryById(String id) {
        return baseQuery() + " AND fb.id = '" + id + "'";
    }

}
