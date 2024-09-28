create table if not exists sc_profile_services(
    profile_id varchar(40) not null,
    service_id varchar(40) not null,
    constraint fk_profile_services_profile_id foreign key (profile_id) references sc_profiles (id),
    constraint fk_profile_services_service_id foreign key (service_id) references sc_services (id)
);
create index profile_id_i_profile_services on sc_profile_services (profile_id);
create index service_id_i_profile_services on sc_profile_services (service_id);
create unique index profile_id_service_id_ui_profile_services on sc_profile_services (profile_id, service_id);