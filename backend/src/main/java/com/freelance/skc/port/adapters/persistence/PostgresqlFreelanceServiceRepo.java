package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.service.FreelanceService;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

import static com.freelance.skc.port.adapters.persistence.models.FreelanceServiceSQLModel.*;

@Repository
public class PostgresqlFreelanceServiceRepo implements FreelanceServiceRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlFreelanceServiceRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<FreelanceService> asFreelanceServiceRowMapper() {
        return (rs, rowNum) -> new FreelanceService(
                rs.getString(idCol),
                rs.getString(nameCol),
                rs.getString(descriptionCol),
                rs.getString(parentIdCol)
        );
    }

    @Override
    public void save(@NotNull FreelanceService freelanceService) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4})
                values
                (:{1}, :{2}, :{3}, :{4})
                """, table,
                idCol, nameCol, descriptionCol, parentIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, freelanceService.id())
                .addValue(nameCol, freelanceService.name())
                .addValue(descriptionCol, freelanceService.description())
                .addValue(parentIdCol, freelanceService.parentId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(@NotNull String id) {
        jdbcPostgresExecuterRepo.delete(table, id);

    }

    @Override
    public @NotNull List<FreelanceService> all() {
        return jdbcPostgresExecuterRepo.all(table, asFreelanceServiceRowMapper());
    }
}
