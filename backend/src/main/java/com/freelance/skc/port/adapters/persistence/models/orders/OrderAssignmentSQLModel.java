package com.freelance.skc.port.adapters.persistence.models.orders;

import org.springframework.stereotype.Component;

@Component
public class OrderAssignmentSQLModel {

    public static final String table = "sc_order_assignments";

    public static final String idCol = "id";
    public static final String clientIdCol = "client_id";
    public static final String profileIdCol = "profile_id";
    public static final String startDateCol = "start_date";
    public static final String endDateCol = "end_date";
}
