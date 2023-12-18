package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class ClientOrderSQLModel {

    public static final String table = "sc_client_orders";

    public static final String id = "id";
    public static final String clientId = "client_id";
    public static final String title = "title";
    public static final String description = "description";
    public static final String orderType = "order_type";
    public static final String endDate = "end_date";
}
