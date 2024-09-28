alter table sc_client_orders add status varchar(128);
alter table sc_order_applications rename to sc_client_order_responses;
create table if not exists sc_order_assignments(
    id varchar(40) not null,
    client_id varchar(40) not null,
    profile_id varchar(40) not null,
    start_date timestamp,
    end_date timestamp,
    primary key (id),
    constraint fk_order_assignments_client_id foreign key (client_id) references sc_users (id),
    constraint fk_order_assignments_profile_id foreign key (profile_id) references sc_profiles (id)
);