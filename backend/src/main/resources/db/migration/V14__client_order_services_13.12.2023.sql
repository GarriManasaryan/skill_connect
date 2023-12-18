create table if not exists sc_client_order_services(
    client_order_id varchar(40) not null,
    service_id varchar(40) not null,
    constraint fk_client_order_services_client_order_id foreign key (client_order_id) references sc_client_orders (id),
    constraint fk_client_order_services_service_id foreign key (service_id) references sc_services (id)
);