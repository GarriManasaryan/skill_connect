package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class UserSQLModel {

    public static final String table = "sc_users";

    public static final String idCol = "id";
    public static final String nameCol = "name";
    public static final String emailCol = "email";
    public static final String roleCol = "role";
    public static final String ageCol = "age";
    public static final String discriminatorCol = "discriminator";
    public static final String timeZoneCol = "time_zone";
}
