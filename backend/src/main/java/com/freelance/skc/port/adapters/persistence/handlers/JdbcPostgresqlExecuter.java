package com.freelance.skc.port.adapters.persistence.handlers;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JdbcPostgresqlExecuter implements JdbcPostgresExecuterRepo {


    private final NamedParameterJdbcOperations jdbcOperations;

    public JdbcPostgresqlExecuter(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static String psqlExceptionMessage(DataAccessException e) {
        var exceptionMessage = "Unmapped DataAccessException";
        var exceptionSourceMessage = e.getMessage();

        if (e.getCause() instanceof PSQLException sqlException) {
            // нужно всегда сужать тип ошибки до PSQLException и до getServerErrorMessage и тд, и только в конце конкретно, как внизу
            if (sqlException.getServerErrorMessage() != null && sqlException.getServerErrorMessage().getMessage() != null) {
                var sqlMessage = sqlException.getServerErrorMessage().getMessage();
                if (sqlException.getServerErrorMessage().getMessage().contains("violates foreign key")) {
                    exceptionMessage = "FK violation: " + sqlMessage;
                }
                else if (sqlException.getServerErrorMessage().getMessage().contains("violates not-null constraint")) {
                    exceptionMessage = "NullNotAllowed: " + sqlMessage;
                }
                else if (sqlException.getServerErrorMessage().getMessage().contains("duplicate key value violates unique constraint")) {
                    exceptionMessage = "DuplicateKeyViolation: " + sqlMessage;
                }
                else if (sqlException.getServerErrorMessage().getMessage().contains("No value registered for")) {
                    exceptionMessage = "MissingParam: " + sqlMessage;
                }
            }
        } else if (exceptionSourceMessage.contains("No value registered for")) {
            exceptionMessage = "MissingParam: " + exceptionSourceMessage;
        }
        return exceptionMessage + ": " + exceptionSourceMessage;
    }


    public void update(String sqlTemplate, MapSqlParameterSource params) {
        try {
            jdbcOperations.update(sqlTemplate, params);
        } catch (DataAccessException e) {
            throw new IllegalStateException(psqlExceptionMessage(e));
        }
    }

    public void delete(String tableName, String id){
        var sqlTemplate = String.format("""
                delete from %s 
                where id = :id""", tableName);

        var params = new MapSqlParameterSource()
                .addValue("id", id);

        update(sqlTemplate, params);
    }

    public <T> List<T> all(String tableName, RowMapper<T> rowMapper){
        var sqlTemplate = String.format("select * from %s", tableName);

        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), rowMapper);
    }

    @Override
    public <T> Optional<T> ofId(String tableName, String id, RowMapper<T> rowMapper) {
        var sqlTemplate = String.format("""
                select * from %s 
                where id = :id""", tableName);

        var params = new MapSqlParameterSource()
                .addValue("id", id);

        return jdbcOperations.query(sqlTemplate, params, rowMapper).stream().findFirst();
    }

    @Override
    public <T extends BaseListSQLModel> void updateEntityListValues(String entityId, List<String> valuesToAdd, T baseListSQLModel) {
        if (!valuesToAdd.isEmpty()){
            var sqlTemplateBase = MessageFormat.format("""
                    insert into {0}
                    ({1}, {2})
                    values 
                    """, baseListSQLModel.table(), baseListSQLModel.mainIdCol(), baseListSQLModel.valuesIdCol());

            List<String> values = new ArrayList<>();
            valuesToAdd.forEach(
                    valueToLink -> values.add(String.format("('%s', '%s')", entityId, valueToLink))
            );

            jdbcOperations.update(sqlTemplateBase + String.join(", ", values), new MapSqlParameterSource());
        }
    }

    @Override
    public <T> List<T> customQuery(String sqlTemplate, MapSqlParameterSource params, RowMapper<T> rowMapper) {
        return jdbcOperations.query(sqlTemplate, params, rowMapper);
    }

    @Override
    public <T> List<T> customQuery(String sqlTemplate, RowMapper<T> rowMapper) {
        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), rowMapper);
    }
}
