package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.user.Role;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserDiscriminator;
import com.freelance.skc.domain.user.UserRepo;
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
public class PostgresqlUserRepo implements UserRepo {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlUserRepo(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static RowMapper<User> asUserRowMapper(){
        return (rs, rowNum) -> new User(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("email"),
                Role.valueOf(rs.getString("role")),
                rs.getInt("age"),
                UserDiscriminator.valueOf(rs.getString("discriminator")),
                rs.getString("time_zone")
        );
    }

    @Override
    public void save(User user) {
        var sqlTemplate = """
                insert into sc_users
                (id, name, email, role, age, discriminator, time_zone)
                values
                (:id, :name, :email, :role, :age, :discriminator, :time_zone)
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", user.id())
                .addValue("name", user.name())
                .addValue("email", user.email())
                .addValue("role", user.role().name())
                .addValue("age", user.age())
                .addValue("discriminator", user.discriminator().name())
                .addValue("time_zone", user.timeZone());

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public void delete(String userId) {
        var sqlTemplate = """
                delete from sc_users
                where id = :id
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", userId);

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public List<User> all() {
        var sqlTemplate = """
                select * from sc_users
                """;

        var queryParams = new MapSqlParameterSource();

        return jdbcOperations.query(sqlTemplate, queryParams, asUserRowMapper());
    }
}
