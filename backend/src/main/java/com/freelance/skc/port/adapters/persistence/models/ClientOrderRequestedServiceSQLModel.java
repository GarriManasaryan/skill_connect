package com.freelance.skc.port.adapters.persistence.models;

import org.springframework.stereotype.Component;

@Component
public class ClientOrderRequestedServiceSQLModel {

    public static final String table = "sc_client_order_services";
    public static final String clientOrderIdCol = "client_order_id";
    public static final String serviceIdCol = "service_id";
}
