alter table sc_users drop column last_updated_at;
alter table sc_users add time_zone varchar(32);

