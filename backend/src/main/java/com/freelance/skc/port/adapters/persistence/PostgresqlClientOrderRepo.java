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
                rs.getString(idCol),
                rs.getString(clientIdCol),
                rs.getString(titleCol),
                rs.getString(descriptionCol),
                OrderType.stringToEnum(rs.getString(orderTypeCol)),
                rs.getObject(endDateCol, OffsetDateTime.class)
        );
    }

    @Override
    public void save(@NotNull ClientOrder clientOrder) {

        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6})
                values
                (:{1}, :{2}, :{3}, :{4}, :{5}, :{6}::timestamp)
                """, table,
                idCol, clientIdCol, titleCol, descriptionCol, orderTypeCol, endDateCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, clientOrder.id())
                .addValue(clientIdCol, clientOrder.clientId())
                .addValue(titleCol, clientOrder.title())
                .addValue(descriptionCol, clientOrder.description())
                .addValue(orderTypeCol, OrderType.enumToString(clientOrder.orderType()))
                .addValue(endDateCol, clientOrder.endAt() != null ? new Timestamp(1000 * clientOrder.endAt().toEpochSecond()) : null);

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
