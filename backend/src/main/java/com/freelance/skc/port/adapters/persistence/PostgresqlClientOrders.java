package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.orders.ClientOrder;
import com.freelance.skc.domain.orders.ClientOrderRepo;
import com.freelance.skc.domain.orders.OrderType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class PostgresqlClientOrders implements ClientOrderRepo {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlClientOrders(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static RowMapper<ClientOrder> asClientOrderRowMapping(){
        return (rs, rowNum) -> new ClientOrder(
                rs.getString("id"),
                rs.getString("client_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("service_id"),
                OrderType.stringToEnum(rs.getString("order_type")),
                rs.getObject("end_date", OffsetDateTime.class)
        );
    }

    @Override
    public void save(ClientOrder clientOrder) {
        var sqlTemplate = """
                insert into sc_client_orders
                (id, client_id, title, description, service_id, order_type, end_date)
                values
                (:id, :client_id, :title, :description, :service_id, :order_type, :end_date::timestamp)
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", clientOrder.id())
                .addValue("client_id", clientOrder.clientId())
                .addValue("title", clientOrder.title())
                .addValue("description", clientOrder.description())
                .addValue("service_id", clientOrder.serviceId())
                .addValue("order_type", OrderType.enumToString(clientOrder.orderType()))
                .addValue("end_date",  clientOrder.endAt() != null ? new Timestamp(1000 * clientOrder.endAt().toEpochSecond()) : null );

        try{
            jdbcOperations.update(sqlTemplate, queryParams);
        }
        catch (DataAccessException e){
            if (e.getCause().toString().contains("violates foreign key constraint")){
                throw new IllegalStateException("Foreign key not found (DB)");
            }
        }

    }

    @Override
    public void delete(String id) {
        var sqlTemplate = """
                delete from sc_client_orders
                where id = :id
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", id);

        jdbcOperations.update(sqlTemplate, queryParams);
    }

    @Override
    public List<ClientOrder> all() {
        var sqlTemplate = """
                select * from sc_client_orders
                """;

        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asClientOrderRowMapping());
    }
}
