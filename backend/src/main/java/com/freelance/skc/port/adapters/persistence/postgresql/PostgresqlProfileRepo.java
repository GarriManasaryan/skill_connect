package com.freelance.skc.port.adapters.persistence.postgresql;

import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JdbcPostgresExecuterRepo;
import com.freelance.skc.port.adapters.persistence.handlers.JsonOperations;
import com.rabbitmq.client.DnsSrvRecordAddressResolver;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

import com.freelance.skc.port.adapters.persistence.models.profile.*;

@Repository
public class PostgresqlProfileRepo implements ProfileRepo {

    private final JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo;
    private final JsonOperations jsonOperations;

    public PostgresqlProfileRepo(JdbcPostgresExecuterRepo jdbcPostgresExecuterRepo, JsonOperations jsonOperations) {
        this.jdbcPostgresExecuterRepo = jdbcPostgresExecuterRepo;
        this.jsonOperations = jsonOperations;
    }

    private RowMapper<Profile> asProfileRowMapper() {
        return (rs, rowNum) -> new Profile(
                rs.getString(ProfileSQLModel.idCol),
                rs.getString(ProfileSQLModel.titleCol),
                rs.getString(ProfileSQLModel.descriptionCol),
                rs.getString(ProfileSQLModel.userIdCol),
                jsonOperations.deserializeFromStringToListJson(rs.getString(ProfileSkillsSQLModel.skillIdCol)),
                jsonOperations.deserializeFromStringToListJson(rs.getString(ProfileServicesSQLModel.serviceIdCol))

        );
    }

    @Override
    public void save(Profile profile) {
        // profile
        updateProfile(profile);

        // profile skills
        jdbcPostgresExecuterRepo.updateEntityListValues(profile.id(), profile.skillIds(), new ProfileSkillsSQLModel());

        // profile services
        jdbcPostgresExecuterRepo.updateEntityListValues(profile.id(), profile.serviceIds(), new ProfileServicesSQLModel());
    }

    private void updateProfile(Profile profile){
        var sqlTemplate = MessageFormat.format("""
                insert into {0}
                ({1}, {2}, {3}, {4})
                values
                (:{1}, :{2}, :{3}, :{4})
                """, ProfileSQLModel.table,
                ProfileSQLModel.idCol, ProfileSQLModel.titleCol, ProfileSQLModel.descriptionCol, ProfileSQLModel.userIdCol);

        var params = new MapSqlParameterSource()
                .addValue(ProfileSQLModel.idCol, profile.id())
                .addValue(ProfileSQLModel.titleCol, profile.title())
                .addValue(ProfileSQLModel.descriptionCol, profile.description())
                .addValue(ProfileSQLModel.userIdCol, profile.userId());

        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
    }


    @Override
    public void delete(String id) {
        jdbcPostgresExecuterRepo.delete(ProfileSQLModel.table, id);
    }

    @Override
    public List<Profile> all() {
        return jdbcPostgresExecuterRepo.customQuery(query(), asProfileRowMapper());
    }

    @Override
    public Optional<Profile> ofId(String id) {
        return jdbcPostgresExecuterRepo.customQuery(query(id), asProfileRowMapper()).stream().findFirst();
    }

//    @Override
//    public void addPic(String profileId, MultipartFile file) throws IOException {
//        var sqlTemplate = MessageFormat.format("""
//                update {0}
//                set {2} = :{2}::bytea
//                where {1} = :{1}
//                """, ProfileSQLModel.table,
//                ProfileSQLModel.idCol, ProfileSQLModel.sellerPicCol);
//
//        var params = new MapSqlParameterSource()
//                .addValue(ProfileSQLModel.sellerPicCol, file.getBytes())
//                .addValue(ProfileSQLModel.idCol, profileId);
//
//        jdbcPostgresExecuterRepo.update(sqlTemplate, params);
//
//    }

    private static String baseQuery(){
        return """
                WITH pr_sv AS (
                    SELECT psv.profile_id,\s
                           jsonb_agg(psv.service_id) AS service_id\s
                    FROM sc_profile_services psv\s
                    GROUP BY psv.profile_id
                ), pr_sk AS (
                    SELECT psk.profile_id,\s
                           jsonb_agg(psk.skill_id) AS skill_id\s
                    FROM sc_profile_skills psk\s
                    GROUP BY psk.profile_id
                )
                SELECT pr.*,\s
                       COALESCE(pr_sv.service_id, '[]'::jsonb) AS service_id,\s
                       COALESCE(pr_sk.skill_id, '[]'::jsonb) AS skill_id
                FROM sc_profiles pr\s
                LEFT JOIN pr_sv ON pr.id = pr_sv.profile_id\s
                LEFT JOIN pr_sk ON pr.id = pr_sk.profile_id
                """;
    }

    private static String query(){
        return baseQuery();
    }

    private static String query(String id){
        var sql = baseQuery();
        return sql + " where pr.id = '" + id + "'";
    }

}
