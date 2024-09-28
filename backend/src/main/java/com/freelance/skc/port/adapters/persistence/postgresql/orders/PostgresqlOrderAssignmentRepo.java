package com.freelance.skc.port.adapters.persistence.postgresql.orders;

import com.freelance.skc.domain.orders.assignment.OrderAssignment;
import com.freelance.skc.domain.orders.assignment.OrderAssignmentRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.postgresql.common.PostgresqlNormalizer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.orders.OrderAssignmentSQLModel.*;

@Repository
public class PostgresqlOrderAssignmentRepo implements OrderAssignmentRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlOrderAssignmentRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private RowMapper<OrderAssignment> asOrderAssignmentRowMapper() {
        return (rs, rowNum) -> new OrderAssignment(
                rs.getString(idCol),
                rs.getString(clientIdCol),
                rs.getString(profileIdCol),
                Optional.ofNullable(rs.getObject(startDateCol, OffsetDateTime.class)),
                Optional.ofNullable(rs.getObject(endDateCol, OffsetDateTime.class))
        );
    }

    @Override
    public void save(OrderAssignment orderAssignment) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5})
                values
                (:{1}, :{2}, :{3}, :{4}::timestamp, :{5}::timestamp)
                """, table,
                idCol, clientIdCol, profileIdCol, startDateCol, endDateCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, orderAssignment.id())
                .addValue(clientIdCol, orderAssignment.clientId())
                .addValue(profileIdCol, orderAssignment.profileId())
                .addValue(startDateCol, PostgresqlNormalizer.toTimestamp(orderAssignment.startAt().orElse(null)))
                .addValue(endDateCol, PostgresqlNormalizer.toTimestamp(orderAssignment.endAt().orElse(null)));
                ;

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public List<OrderAssignment> all() {
        return jdbcPostgresExecuterRepo.all(table, asOrderAssignmentRowMapper());
    }

    @Override
    public Optional<OrderAssignment> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asOrderAssignmentRowMapper());
    }
}
