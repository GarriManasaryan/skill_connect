package com.freelance.skc.port.adapters.persistence.postgresql.orders;

import com.freelance.skc.domain.orders.response.ClientOrderResponse;
import com.freelance.skc.domain.orders.response.ClientOrderResponseRepo;
import com.freelance.skc.domain.orders.response.ClientOrderResponseStatus;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.orders.ClientOrderResponseSQLModel.*;


@Repository
public class PostgresqlClientOrderResponseRepo implements ClientOrderResponseRepo {


    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlClientOrderResponseRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<ClientOrderResponse> asOrderApplicationRowMapping() {
        return (rs, rowNum) -> new ClientOrderResponse(
                rs.getString(idCol),
                rs.getString(profileIdCol),
                ClientOrderResponseStatus.valueOf(rs.getString(statusCol)),
                rs.getObject(appliedAtCol, OffsetDateTime.class),
                rs.getString(applicationTextCol),
                rs.getString(clientOrderIdCol)
        );
    }

    @Override
    public void save(@NotNull ClientOrderResponse clientOrderResponse) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6})
                values
                (:{1}, :{2}, :{3}, :{4}::timestamp, :{5}, :{6})
                """, table,
                idCol, profileIdCol, statusCol, appliedAtCol, applicationTextCol, clientOrderIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, clientOrderResponse.id())
                .addValue(profileIdCol, clientOrderResponse.profileId())
                .addValue(statusCol, clientOrderResponse.clientOrderResponseStatus().name())
                .addValue(appliedAtCol, new Timestamp(1000 * clientOrderResponse.appliedAt().toEpochSecond()))
                .addValue(applicationTextCol, clientOrderResponse.applicationText())
                .addValue(clientOrderIdCol, clientOrderResponse.clientOrderId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public List<ClientOrderResponse> all() {
        return jdbcPostgresExecuterRepo.all(table, asOrderApplicationRowMapping());
    }

    @Override
    public Optional<ClientOrderResponse> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asOrderApplicationRowMapping());
    }
}
