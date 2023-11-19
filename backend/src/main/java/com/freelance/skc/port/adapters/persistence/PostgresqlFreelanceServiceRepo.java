package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.service.FreelanceService;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostgresqlFreelanceServiceRepo implements FreelanceServiceRepo {

    private final NamedParameterJdbcOperations jdbcOperations;

    public PostgresqlFreelanceServiceRepo(DataSource dataSource) {
        this.jdbcOperations = new NamedParameterJdbcTemplate(dataSource);
    }

    private static RowMapper<FreelanceService> asFreelanceServiceRowMapper(){
        return (rs, rowNum) -> new FreelanceService(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("parent_id")
        );
    }

    @Override
    public @NotNull List<String> allIds() {
        return all().stream().map(FreelanceService::id).toList();
    }

    @Override
    public void save(@NotNull FreelanceService freelanceService) {
        var sqlTemplate = """
                insert into sc_services
                (id, name, description, parent_id)
                values
                (:id, :name, :description, :parent_id)
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", freelanceService.id())
                .addValue("name", freelanceService.name())
                .addValue("description", freelanceService.description())
                .addValue("parent_id", freelanceService.parentId());

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public void delete(@NotNull String id) {
        var sqlTemplate = """
                delete from sc_services
                where id = :id
                """;

        var queryParams = new MapSqlParameterSource()
                .addValue("id", id);

        jdbcOperations.update(sqlTemplate, queryParams);

    }

    @Override
    public @NotNull List<FreelanceService> all() {
        var sqlTemplate = """
                select * from sc_services
                """;

        return jdbcOperations.query(sqlTemplate, new MapSqlParameterSource(), asFreelanceServiceRowMapper());
    }
}
