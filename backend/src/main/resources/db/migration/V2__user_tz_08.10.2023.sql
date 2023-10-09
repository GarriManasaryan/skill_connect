alter table sc_users add discriminator varchar(128);
alter table sc_users add last_updated_at timestamp with time zone;
