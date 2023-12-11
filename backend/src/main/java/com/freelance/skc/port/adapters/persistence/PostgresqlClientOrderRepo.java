package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.orders.ClientOrder;
import com.freelance.skc.domain.orders.ClientOrderRepo;
import com.freelance.skc.domain.orders.OrderType;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;

import static com.freelance.skc.port.adapters.persistence.models.ClientOrderSQLModel.*;

@Repository
public class PostgresqlClientOrderRepo implements ClientOrderRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlClientOrderRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<ClientOrder> asClientOrderRowMapping() {
        return (rs, rowNum) -> new ClientOrder(
                rs.getString(id),
                rs.getString(clientId),
                rs.getString(title),
                rs.getString(description),
                rs.getString(serviceId),
                OrderType.stringToEnum(rs.getString(orderType)),
                rs.getObject(endDate, OffsetDateTime.class)
        );
    }

    @Override
    public void save(@NotNull ClientOrder clientOrder) {

        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6}, {7})
                values
                (:{1}, :{2}, :{3}, :{4}, :{5}, :{6}, :{7}::timestamp)
                """, table,
                id, clientId, title, description, serviceId, orderType, endDate);

        var params = new MapSqlParameterSource()
                .addValue(id, clientOrder.id())
                .addValue(clientId, clientOrder.clientId())
                .addValue(title, clientOrder.title())
                .addValue(description, clientOrder.description())
                .addValue(serviceId, clientOrder.serviceId())
                .addValue(orderType, OrderType.enumToString(clientOrder.orderType()))
                .addValue(endDate, clientOrder.endAt() != null ? new Timestamp(1000 * clientOrder.endAt().toEpochSecond()) : null);

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public @NotNull List<ClientOrder> all() {
        return jdbcPostgresExecuterRepo.all(table, asClientOrderRowMapping());
    }
}
