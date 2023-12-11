alter table sc_skills add
constraint fk_sca_profile_id foreign key (parent_id) references sc_skills (id);
