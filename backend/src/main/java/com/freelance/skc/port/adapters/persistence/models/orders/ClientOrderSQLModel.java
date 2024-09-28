package com.freelance.skc.port.adapters.persistence.models.orders;

import org.springframework.stereotype.Component;

@Component
public class ClientOrderSQLModel {

    public static final String table = "sc_client_orders";

    public static final String idCol = "id";
    public static final String clientIdCol = "client_id";
    public static final String titleCol = "title";
    public static final String descriptionCol = "description";
    public static final String orderTypeCol = "order_type";
    public static final String statusCol = "status";
    public static final String endDateCol = "end_date";
}
