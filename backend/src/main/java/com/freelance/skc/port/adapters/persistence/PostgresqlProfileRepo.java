package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostgresqlProfileRepo implements ProfileRepo {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlProfileRepo(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static RowMapper<Profile> asProfileRowMapper(){
        return (rs, rowNum) -> new Profile(
                rs.getString("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("user_id")
        );
    }

    @Override
    public void save(Profile profile) {
        var sqlTemplate = """
                insert into sc_profiles
                (id, title, description, user_id)
                values
                (:id, :title, :description, :user_id)
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", profile.id())
                .addValue("title", profile.title())
                .addValue("description", profile.description())
                .addValue("user_id", profile.userId());

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public void delete(String id) {
        var sqlTemplate = """
                delete from sc_profiles
                where id = :id
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", id);

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public List<Profile> all() {
        var sqlTemplate = """
                select * from sc_profiles
                """;
        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asProfileRowMapper());
    }
}
