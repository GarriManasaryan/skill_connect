alter table sc_client_orders drop CONSTRAINT fk_client_orders_service_id;
alter table sc_services add constraint fk_services_parent_id foreign key (parent_id) references sc_services (id);
ALTER TABLE sc_skills RENAME CONSTRAINT fk_sca_profile_id TO fk_skills_parent_id;
alter table sc_client_orders drop column service_id;