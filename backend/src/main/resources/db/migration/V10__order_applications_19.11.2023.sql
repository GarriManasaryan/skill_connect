create table if not exists sc_order_applications(
    id varchar(40) not null,
    profile_id varchar(40) not null,
    status varchar(64) not null,
    applied_at timestamp not null,
    application_text text not null,
    client_order_id varchar(40) not null,
    primary key (id),
    constraint fk_order_applications_client_order_id foreign key (client_order_id) references sc_client_orders (id),
    constraint fk_order_applications_profile_id foreign key (profile_id) references sc_profiles (id)
);