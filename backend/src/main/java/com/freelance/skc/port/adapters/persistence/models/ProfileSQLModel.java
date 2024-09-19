package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class ProfileSQLModel {

    public static final String table = "sc_profiles";

    public static final String idCol = "id";
    public static final String titleCol = "title";
    public static final String descriptionCol = "description";
    public static final String sellerPicCol = "profile_seller_pic";
    public static final String userIdCol = "user_id";
}
