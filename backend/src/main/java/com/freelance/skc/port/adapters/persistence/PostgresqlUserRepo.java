package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.user.Role;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserDiscriminator;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import static com.freelance.skc.port.adapters.persistence.models.UserSQLModel.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

@Repository
public class PostgresqlUserRepo implements UserRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlUserRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<User> asUserRowMapper(){
        return (rs, rowNum) -> new User(
                rs.getString(idCol),
                rs.getString(nameCol),
                rs.getString(emailCol),
                Role.valueOf(rs.getString(roleCol)),
                rs.getInt(ageCol),
                UserDiscriminator.valueOf(rs.getString(discriminatorCol)),
                rs.getString(timeZoneCol)
        );
    }

    @Override
    public void save(User user) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5}, {6}, {7})
                values
                (:{1}, :{2}, :{3}, :{4}, :{5}, :{6}, :{7})
                """, table,
                idCol, nameCol, emailCol, roleCol, ageCol, discriminatorCol, timeZoneCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, user.id())
                .addValue(nameCol, user.name())
                .addValue(emailCol, user.email())
                .addValue(roleCol, user.role().name())
                .addValue(ageCol, user.age())
                .addValue(discriminatorCol, user.discriminator().name())
                .addValue(timeZoneCol, user.timeZone());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String userId) {
        jdbcPostgresExecuterRepo.delete(table, idCol);

    }

    @Override
    public List<User> all() {
        var asc = jdbcPostgresExecuterRepo.all(table, asUserRowMapper());
        return jdbcPostgresExecuterRepo.all(table, asUserRowMapper());
    }
}
