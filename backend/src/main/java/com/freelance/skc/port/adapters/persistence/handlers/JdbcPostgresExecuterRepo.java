package com.freelance.skc.port.adapters.persistence.handlers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public interface JdbcPostgresExecuterRepo {

    void update(String sqlTemplate, MapSqlParameterSource params);

    void delete(String tableName, String id);

    <T> List<T> all(String tableName, RowMapper<T> rowMapper);

}
