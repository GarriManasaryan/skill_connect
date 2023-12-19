package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class ProfileSQLModel {

    public static final String table = "sc_profiles";

    public static final String id = "id";
    public static final String title = "title";
    public static final String description = "description";
    public static final String sellerPic = "profile_seller_pic";
    public static final String userId = "user_id";
}
