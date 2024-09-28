package com.freelance.skc.port.adapters.persistence.postgresql.product.feature;

import com.freelance.skc.domain.product.feature.*;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureBaseSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureCategoriesSQLModel;
import com.freelance.skc.port.adapters.persistence.models.product.feature.FeatureNumericSQLModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;


@Repository
public class PostgresqlFeatureNumericRepo implements FeatureNumericRepo {

    private final FeatureBaseOperationRepo featureBaseOperationRepo;
    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public PostgresqlFeatureNumericRepo(FeatureBaseOperationRepo featureBaseOperationRepo) {
        this.featureBaseOperationRepo = featureBaseOperationRepo;
        this.jsonOperations = featureBaseOperationRepo.jsonOperationsExecuter();
        this.jdbcPostgresExecuterRepo = featureBaseOperationRepo.jdbcPostgresExecuter();
    }

    private RowMapper<FeatureNumeric> asFeatureNumericRowMapper() {
        return (rs, rowNum) -> new FeatureNumeric(
                rs.getString(FeatureBaseSQLModel.idCol),
                rs.getString(FeatureBaseSQLModel.nameCol),
                Optional.ofNullable(rs.getString(FeatureBaseSQLModel.descriptionCol)),
                Optional.ofNullable(rs.getString(FeatureBaseSQLModel.parentIdCol)),
                jsonOperations.deserializeFromStringToListJson(rs.getString("feature_categories")),
                rs.getDouble(FeatureNumericSQLModel.fromValueCol),
                Optional.of(rs.getDouble(FeatureNumericSQLModel.toValueCol)),
                Optional.ofNullable(rs.getString(FeatureNumericSQLModel.unitCol)),
                Optional.ofNullable(rs.getString(FeatureNumericSQLModel.lessThanTextId)),
                Optional.ofNullable(rs.getString(FeatureNumericSQLModel.moreThanTextId))

        );
    }

    @Override
    public List<FeatureNumeric> all() {
        return jdbcPostgresExecuterRepo.customQuery(query(), asFeatureNumericRowMapper());
    }

    @Override
    public void save(FeatureNumeric domain) {
        // base feature
        featureBaseOperationRepo.saveFeatureBase(domain);
        // text feature
        saveFeatureNumeric(domain);
        // categories
        jdbcPostgresExecuterRepo.updateEntityListValues(domain.id(), domain.categoryIds(), new FeatureCategoriesSQLModel());
    }

    private void saveFeatureNumeric(FeatureNumeric domain) {
        var sqlTemplate = MessageFormat.format("""
                INSERT INTO {0}
                ({1}, {2}, {3}, {4}, {5}, {6})
                VALUES
                (:{1}, :{2}, :{3}, :{4}, :{5}, :{6})
                """, FeatureNumericSQLModel.table,
                FeatureNumericSQLModel.idCol, FeatureNumericSQLModel.fromValueCol, FeatureNumericSQLModel.toValueCol, FeatureNumericSQLModel.unitCol, FeatureNumericSQLModel.lessThanTextId, FeatureNumericSQLModel.moreThanTextId);


        var params = new MapSqlParameterSource()
                .addValue(FeatureNumericSQLModel.idCol, domain.id())
                .addValue(FeatureNumericSQLModel.fromValueCol, domain.from())
                .addValue(FeatureNumericSQLModel.toValueCol, domain.to().orElse(null))
                .addValue(FeatureNumericSQLModel.unitCol, domain.unit().orElse(null))
                .addValue(FeatureNumericSQLModel.lessThanTextId, domain.lessThanText().orElse(null))
                .addValue(FeatureNumericSQLModel.moreThanTextId, domain.moreThanText().orElse(null))
                ;

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
    }

    @Override
    public Optional<FeatureNumeric> ofId(String id) {
        return jdbcPostgresExecuterRepo.customQuery(queryById(id), asFeatureNumericRowMapper()).stream().findFirst();
    }

    @Override
    public void delete(String id) {
        // cascade удалит из дочерних таблиц также
        jdbcPostgresExecuterRepo.delete(FeatureBaseSQLModel.table, id);

    }

    private static String baseQuery() {
        var baseJoinQuery = FeatureBaseOperationRepo.getFeatureBaseQueryWithJoin()
                .replaceAll("sc_features_discriminator", FeatureNumericSQLModel.table)
                .replaceAll("FEATURE_DISCRIMINATOR", FeatureDiscriminator.FEATURE_NUMERIC.name())
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
