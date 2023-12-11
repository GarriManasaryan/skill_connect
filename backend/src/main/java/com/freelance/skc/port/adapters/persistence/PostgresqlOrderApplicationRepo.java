package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.orders.OrderApplication;
import com.freelance.skc.domain.orders.OrderApplicationRepo;
import com.freelance.skc.domain.orders.OrderApplicationStatus;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;

import static com.freelance.skc.port.adapters.persistence.models.OrderApplicationSQLModel.*;


@Repository
public class PostgresqlOrderApplicationRepo implements OrderApplicationRepo {


    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlOrderApplicationRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<OrderApplication> asOrderApplicationRowMapping() {
        return (rs, rowNum) -> new OrderApplication(
                rs.getString(id),
                rs.getString(profileId),
                OrderApplicationStatus.valueOf(rs.getString(status)),
                rs.getObject(appliedAt, OffsetDateTime.class),
                rs.getString(applicationText),
                rs.getString(clientOrderId)
        );
    }

    @Override
    public void save(@NotNull OrderApplication orderApplication) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6})
                values
                (:{1}, :{2}, :{3}, :{4}::timestamp, :{5}, :{6})
                """, table,
                id, profileId, status, appliedAt, applicationText, clientOrderId);

        var params = new MapSqlParameterSource()
                .addValue(id, orderApplication.id())
                .addValue(profileId, orderApplication.profileId())
                .addValue(status, orderApplication.orderApplicationStatus().name())
                .addValue(appliedAt, new Timestamp(1000 * orderApplication.appliedAt().toEpochSecond()))
                .addValue(applicationText, orderApplication.applicationText())
                .addValue(clientOrderId, orderApplication.clientOrderId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public List<OrderApplication> all() {
        return jdbcPostgresExecuterRepo.all(table, asOrderApplicationRowMapping());
    }
}
