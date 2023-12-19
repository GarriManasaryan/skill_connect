package com.freelance.skc.port.adapters.persistence;

import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import static com.freelance.skc.port.adapters.persistence.models.ProfileSQLModel.*;

@Repository
public class PostgresqlProfileRepo implements ProfileRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;

    public PostgresqlProfileRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
    }

    private static RowMapper<Profile> asProfileRowMapper() {
        return (rs, rowNum) -> new Profile(
                rs.getString(id),
                rs.getString(title),
                rs.getString(description),
                rs.getBytes(sellerPic),
                rs.getString(userId)
        );
    }

    @Override
    public void save(Profile profile) {
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4}, {5})
                values
                (:{1}, :{2}, :{3}, :{4}, :{5}::bytea)
                """, table,
                id, title, description, userId, sellerPic);

        var params = new MapSqlParameterSource()
                .addValue(id, profile.id())
                .addValue(title, profile.title())
                .addValue(description, profile.description())
                .addValue(sellerPic, profile.sellerPic())
                .addValue(userId, profile.userId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }

    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(table, id);
    }

    @Override
    public List<Profile> all() {
        return jdbcPostgresExecuterRepo.all(table, asProfileRowMapper());
    }

    @Override
    public Optional<Profile> ofId(String id) {
        return jdbcPostgresExecuterRepo.ofId(table, id, asProfileRowMapper());
    }

    @Override
    public void addPic(String profileId, MultipartFile file) throws IOException {
        var sqlTemplate = MessageFormat.format("""
                update {0}
                set {2} = :{2}::bytea
                where {1} = :{1}
                """, table,
                id, sellerPic);

        var params = new MapSqlParameterSource()
                .addValue(sellerPic, file.getBytes())
                .addValue(id, profileId);

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);

    }
}
