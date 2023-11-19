package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.orders.*;
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
public class PostgresqlOrderApplicationRepo implements OrderApplicationRepo {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlOrderApplicationRepo(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static RowMapper<OrderApplication> asOrderApplicationRowMapping(){
        return (rs, rowNum) -> new OrderApplication(
                rs.getString("id"),
                rs.getString("profile_id"),
                OrderApplicationStatus.valueOf(rs.getString("status")),
                rs.getObject("applied_at", OffsetDateTime.class),
                rs.getString("application_text"),
                rs.getString("client_order_id")
        );
    }

    @Override
    public void save(OrderApplication orderApplication) {
        var sqlTemplate = """
                insert into sc_order_applications
                (id, profile_id, status, applied_at, application_text, client_order_id)
                values
                (:id, :profile_id, :status, :applied_at::timestamp, :application_text, :client_order_id)
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", orderApplication.id())
                .addValue("profile_id", orderApplication.profileId())
                .addValue("status", orderApplication.orderApplicationStatus().name())
                .addValue("applied_at", new Timestamp(1000 * orderApplication.appliedAt().toEpochSecond()))
                .addValue("application_text", orderApplication.applicationText())
                .addValue("client_order_id", orderApplication.clientOrderId());

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
                delete from sc_order_applications
                where id = :id
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", id);

        jdbcOperations.update(sqlTemplate, queryParams);
    }

    @Override
    public List<OrderApplication> all() {
        var sqlTemplate = """
                select * from sc_order_applications
                """;

        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asOrderApplicationRowMapping());
    }
}
