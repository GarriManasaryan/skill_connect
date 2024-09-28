package com.freelance.skc.port.adapters.persistence.postgresql.orders;

import com.freelance.skc.domain.orders.client.ClientOrder;
import com.freelance.skc.domain.orders.client.ClientOrderRepo;
import com.freelance.skc.domain.orders.client.ClientOrderStatus;
import com.freelance.skc.domain.orders.client.OrderType;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import com.freelance.skc.port.adapters.persistence.models.orders.ClientOrderServicesSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.*;

import static com.freelance.skc.port.adapters.persistence.models.orders.ClientOrderSQLModel.*;

@Repository
public class PostgresqlClientOrderRepo implements ClientOrderRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public PostgresqlClientOrderRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo, JsonOperations jsonOperations) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
        this.jsonOperations = jsonOperations;
    }

    private RowMapper<ClientOrder> asClientOrderRowMapping() {
        return (rs, rowNum) -> new ClientOrder(
                rs.getString(idCol),
                rs.getString(clientIdCol),
                rs.getString(titleCol),
                rs.getString(descriptionCol),
                jsonOperations.asEntityIdsRawMapper(rs.getString("service_id")),
                OrderType.valueOf(rs.getString(orderTypeCol)),
                ClientOrderStatus.valueOf(rs.getString(statusCol)),
                rs.getObject(endDateCol, OffsetDateTime.class)
        );
    }

    @Override
    public void save(@NotNull ClientOrder clientOrder) {

        // save client order
        saveClientOrder(clientOrder);

        // save client order services
        jdbcPostgresExecuterRepo.updateEntityListValues(clientOrder.id(), clientOrder.serviceIds(), new ClientOrderServicesSQLModel());

    }

    private void saveClientOrder(ClientOrder clientOrder) {

        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6}, {7})
                values
                (:{1}, :{2}, :{3}, :{4}, :{5}, :{6}, :{7}::timestamp)
                """, table,
                idCol, clientIdCol, titleCol, descriptionCol, orderTypeCol, statusCol, endDateCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, clientOrder.id())
                .addValue(clientIdCol, clientOrder.clientId())
                .addValue(titleCol, clientOrder.title())
                .addValue(descriptionCol, clientOrder.description())
                .addValue(orderTypeCol, clientOrder.orderType().name())
                .addValue(statusCol, clientOrder.status().name())
                .addValue(endDateCol, clientOrder.endAt() != null ? new Timestamp(1000 * clientOrder.endAt().toEpochSecond()) : null);

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public @NotNull List<ClientOrder> all() {
        return jdbcPostgresExecuterRepo.customQuery(query(), asClientOrderRowMapping());
    }

    @Override
    public Optional<ClientOrder> ofId(String id) {
        return jdbcPostgresExecuterRepo.customQuery(query(id), asClientOrderRowMapping()).stream().findFirst();
    }

    private String baseQuery(){
        return """
                select 
                    co.*, 
                    coalesce(jsonb_agg(cos.service_id) filter (where cos.service_id is not null), '[]'::jsonb) as service_id 
                from sc_client_orders co 
                left join sc_client_order_services cos on co.id = cos.client_order_id 
                where_statement
                group by co.id 
                """;
    }

    private String query(){
        return baseQuery().replaceAll("where_statement", "");
    }

    private String query(String id){
        return baseQuery().replaceAll("where_statement", String.format(" where co.id = '%s' ", id)) ;
    }

}
