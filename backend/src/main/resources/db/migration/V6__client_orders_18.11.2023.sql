create table if not exists sc_client_orders(
    id varchar(40) not null,
    client_id varchar(40) not null,
    title text not null,
    description text not null,
    service_id varchar(40) not null,
    order_type varchar(40) not null,
    end_date timestamp,
    primary key (id),
    constraint fk_client_orders_service_id foreign key (service_id) references sc_services (id)
);