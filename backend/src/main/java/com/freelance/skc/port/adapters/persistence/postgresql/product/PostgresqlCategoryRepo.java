package com.freelance.skc.port.adapters.persistence.postgresql.product;

import com.freelance.skc.domain.product.category.ProductCategory;
import com.freelance.skc.domain.product.category.ProductCategoryRepo;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.product.CategorySQLModel.*;

@Repository
public class PostgresqlCategoryRepo implements ProductCategoryRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlCategoryRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<ProductCategory> asProductCategoryRowMapper() {
        return (rs, rowNum) -> new ProductCategory(
                rs.getString(idCol),
                rs.getString(nameCol),
                rs.getString(descriptionCol),
                rs.getString(parentIdCol)
        );
    }

    @Override
    public void save(@NotNull ProductCategory productCategory) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4})
                values
                (:{1}, :{2}, :{3}, :{4})
                """, table,
                idCol, nameCol, descriptionCol, parentIdCol);

        var params = new MapSqlParameterSource()
                .addValue(idCol, productCategory.id())
                .addValue(nameCol, productCategory.name())
                .addValue(descriptionCol, productCategory.description())
                .addValue(parentIdCol, productCategory.parentId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(@NotNull String id) {
        jdbcPostgresExecuterRepo.delete(table, id);

    }

    @Override
    public @NotNull List<ProductCategory> all() {
        return jdbcPostgresExecuterRepo.all(table, asProductCategoryRowMapper());
    }

    @Override
    public Optional<ProductCategory> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asProductCategoryRowMapper());
    }
}
