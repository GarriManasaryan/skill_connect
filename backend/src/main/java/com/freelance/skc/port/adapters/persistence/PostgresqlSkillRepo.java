package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

import static com.freelance.skc.port.adapters.persistence.models.SkillSQLModel.*;

@Repository
public class PostgresqlSkillRepo implements SkillRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlSkillRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<Skill> asSkillRowMapper() {
        return (rs, rowNum) -> new Skill(
                rs.getString(id),
                rs.getString(name),
                rs.getString(description),
                rs.getString(parentId)
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
                id, name, description, parentId);

        var params = new MapSqlParameterSource()
                .addValue(id, skill.id())
                .addValue(name, skill.name())
                .addValue(description, skill.description())
                .addValue(parentId, skill.parentId());

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
}
