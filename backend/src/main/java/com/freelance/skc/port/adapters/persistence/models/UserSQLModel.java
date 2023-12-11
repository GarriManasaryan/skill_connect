package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class UserSQLModel {

    public static final String table = "sc_users";

    public static final String id = "id";
    public static final String name = "name";
    public static final String email = "email";
    public static final String role = "role";
    public static final String age = "age";
    public static final String discriminator = "discriminator";
    public static final String timeZone = "time_zone";
}
