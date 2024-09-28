package com.freelance.skc.port.adapters.persistence.postgresql;

import com.freelance.skc.domain.service.MasterService;
import com.freelance.skc.domain.service.MasterServiceRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.MasterServiceSQLModel.*;

@Repository
public class PostgresqlMasterServiceRepo implements MasterServiceRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlMasterServiceRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<MasterService> asMasterServiceRowMapper() {
        return (rs, rowNum) -> new MasterService(
                rs.getString(idCol),
                rs.getString(nameCol),
                rs.getString(descriptionCol),
                rs.getString(parentIdCol)
        );
    }

    @Override
    public void save(@NotNull MasterService masterService) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4})
                values
                (:{1}, :{2}, :{3}, :{4})
                """, table,
                idCol, nameCol, descriptionCol, parentIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, masterService.id())
                .addValue(nameCol, masterService.name())
                .addValue(descriptionCol, masterService.description())
                .addValue(parentIdCol, masterService.parentId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(@NotNull String id) {
        jdbcPostgresExecuterRepo.delete(table, id);

    }

    @Override
    public @NotNull List<MasterService> all() {
        return jdbcPostgresExecuterRepo.all(table, asMasterServiceRowMapper());
    }

    @Override
    public Optional<MasterService> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asMasterServiceRowMapper());
    }
}
