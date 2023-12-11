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
                rs.getString(id),
                rs.getString(name),
                rs.getString(email),
                Role.valueOf(rs.getString(role)),
                rs.getInt(age),
                UserDiscriminator.valueOf(rs.getString(discriminator)),
                rs.getString(timeZone)
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
                id, name, email, role, age, discriminator, timeZone);

        var params = new MapSqlParameterSource()
                .addValue(id, user.id())
                .addValue(name, user.name())
                .addValue(email, user.email())
                .addValue(role, user.role().name())
                .addValue(age, user.age())
                .addValue(discriminator, user.discriminator().name())
                .addValue(timeZone, user.timeZone());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String userId) {
        jdbcPostgresExecuterRepo.delete(table, id);

    }

    @Override
    public List<User> all() {
        return jdbcPostgresExecuterRepo.all(table, asUserRowMapper());
    }
}
