alter table sc_client_orders add
constraint fk_client_orders_client_id foreign key (client_id) references sc_users (id);
