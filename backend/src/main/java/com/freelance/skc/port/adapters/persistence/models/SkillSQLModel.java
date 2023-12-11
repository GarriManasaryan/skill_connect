package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class SkillSQLModel {

    public static final String table = "sc_skills";

    public static final String id = "id";
    public static final String name = "name";
    public static final String description = "description";
    public static final String parentId = "parent_id";
}
