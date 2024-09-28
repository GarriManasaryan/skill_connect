package com.freelance.skc.port.adapters.persistence.postgresql;

import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.SkillSQLModel.*;

@Repository
public class PostgresqlSkillRepo implements SkillRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlSkillRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<Skill> asSkillRowMapper() {
        return (rs, rowNum) -> new Skill(
                rs.getString(idCol),
                rs.getString(nameCol),
                rs.getString(descriptionCol),
                rs.getString(parentIdCol)
        );
    }

    @Override
    public void save(@NotNull Skill skill) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4})
                values
                (:{1}, :{2}, :{3}, :{4})
                """, table,
                idCol, nameCol, descriptionCol, parentIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, skill.id())
                .addValue(nameCol, skill.name())
                .addValue(descriptionCol, skill.description())
                .addValue(parentIdCol, skill.parentId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(@NotNull String id) {
        jdbcPostgresExecuterRepo.delete(table, id);

    }

    @Override
    public @NotNull List<Skill> all() {
        return jdbcPostgresExecuterRepo.all(table, asSkillRowMapper());
    }

    @Override
    public Optional<Skill> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asSkillRowMapper());
    }
}
