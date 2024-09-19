package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class SkillSQLModel {

    public static final String table = "sc_skills";

    public static final String idCol = "id";
    public static final String nameCol = "name";
    public static final String descriptionCol = "description";
    public static final String parentIdCol = "parent_id";
}
