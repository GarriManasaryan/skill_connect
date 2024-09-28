package com.freelance.skc.port.adapters.persistence.handlers;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;
import java.util.Optional;

public interface JdbcPostgresExecuterRepo {

    void update(String sqlTemplate, MapSqlParameterSource params);

    void delete(String tableName, String id);

    <T> List<T> all(String tableName, RowMapper<T> rowMapper);

    <T> Optional<T> ofId(String tableName, String id, RowMapper<T> rowMapper);

    <T extends BaseListSQLModel> void updateEntityListValues(String entityId, List<String> valuesToAdd, T baseListSQLModel);

    <T> List<T> customQuery(String sqlTemplate, MapSqlParameterSource params, RowMapper<T> rowMapper);

    <T> List<T> customQuery(String sqlTemplate, RowMapper<T> rowMapper);

}
