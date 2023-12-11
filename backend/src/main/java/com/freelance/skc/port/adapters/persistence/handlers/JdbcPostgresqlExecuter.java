package com.freelance.skc.port.adapters.persistence.handlers;

import com.freelance.skc.domain.orders.OrderApplication;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcPostgresqlExecuter implements JdbcPostgresExecuterRepo {


    private final NamedParameterJdbcOperations jdbcOperations;

    public JdbcPostgresqlExecuter(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static String psqlExceptionMessage(DataAccessException e) {
        var exceptionMessage = "Unmapped SQL exception";
        if (e.getCause() instanceof PSQLException sqlException) {
            // нужно всегда сужать тип ошибки до PSQLException и до getServerErrorMessage и тд, и только в конце конкретно, как внизу
            if (sqlException.getServerErrorMessage() != null && sqlException.getServerErrorMessage().getMessage() != null && sqlException.getServerErrorMessage().getMessage().contains("violates foreign key")) {
                exceptionMessage = "FK violation: " + sqlException.getServerErrorMessage().getMessage();
            }
        } else {
            exceptionMessage = "FK violation";
        }
        return exceptionMessage;
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


}
