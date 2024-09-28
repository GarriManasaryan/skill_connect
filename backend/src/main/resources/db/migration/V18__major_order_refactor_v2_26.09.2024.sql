create table if not exists sc_profile_skills(
    profile_id varchar(40) not null,
    skill_id varchar(40) not null,
    constraint fk_profile_skills_profile_id foreign key (profile_id) references sc_profiles (id),
    constraint fk_profile_skills_skill_id foreign key (skill_id) references sc_skills (id)
);
create index profile_id_i_profile_skills on sc_profile_skills (profile_id);
create index skill_id_i_profile_skills on sc_profile_skills (skill_id);
create unique index profile_id_skill_id_ui_profile_skills on sc_profile_skills (profile_id, skill_id);
