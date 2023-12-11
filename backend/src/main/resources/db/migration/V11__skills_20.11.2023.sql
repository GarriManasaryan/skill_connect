create table if not exists sc_skills(
    id varchar(40) not null,
    name text not null,
    description text not null,
    parent_id varchar(40),
    primary key (id)
);