package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class OrderApplicationSQLModel {

    public static final String table = "sc_order_applications";

    public static final String id = "id";
    public static final String profileId = "profile_id";
    public static final String status = "status";
    public static final String appliedAt = "applied_at";
    public static final String applicationText = "application_text";
    public static final String clientOrderId = "client_order_id";
}
