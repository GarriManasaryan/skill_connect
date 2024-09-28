package com.freelance.skc.port.adapters.persistence.models.orders;

import org.springframework.stereotype.Component;

@Component
public class ClientOrderResponseSQLModel {

    public static final String table = "sc_client_order_responses";

    public static final String idCol = "id";
    public static final String profileIdCol = "profile_id";
    public static final String statusCol = "status";
    public static final String appliedAtCol = "applied_at";
    public static final String applicationTextCol = "application_text";
    public static final String clientOrderIdCol = "client_order_id";
}
