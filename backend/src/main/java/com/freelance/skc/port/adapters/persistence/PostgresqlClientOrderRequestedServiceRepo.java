package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.orders.ClientOrderRequestedService;
import com.freelance.skc.domain.orders.ClientOrderRequestedServiceRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

import static com.freelance.skc.port.adapters.persistence.models.ClientOrderRequestedServiceSQLModel.*;

@Repository
public class PostgresqlClientOrderRequestedServiceRepo implements ClientOrderRequestedServiceRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlClientOrderRequestedServiceRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<ClientOrderRequestedService> asClientOrderRowMapping() {
        return (rs, rowNum) -> new ClientOrderRequestedService(
                rs.getString(clientOrderIdCol),
                rs.getString(serviceIdCol)
        );
    }

    @Override
    public void save(String clientOrderId, String serviceId) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2})
                values
                (:{1}, :{2})
                """,table,
                clientOrderIdCol, serviceIdCol);

        var params = new MapSqlParameterSource()
                .addValue(clientOrderIdCol, clientOrderId)
                .addValue(serviceIdCol, serviceId);

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String clientOrderId, String serviceId) {
        var sqlTemplate = MessageFormat.format("""
                delete from {0}
                where {1} = :{1} and {2} = :{2} 
                """,table,
                clientOrderIdCol, serviceIdCol);

        var params = new MapSqlParameterSource()
                .addValue(clientOrderIdCol, clientOrderId)
                .addValue(serviceIdCol, serviceId);

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public List<ClientOrderRequestedService> all() {
        return jdbcPostgresExecuterRepo.all(table, asClientOrderRowMapping());
    }
}
