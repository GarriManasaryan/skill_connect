create table if not exists sc_profiles(
    id varchar(40) not null,
    title text not null,
    description text not null,
    user_id varchar(40) not null,
    primary key (id),
    constraint fk_profiles_user_id foreign key (user_id) references sc_users (id)
);