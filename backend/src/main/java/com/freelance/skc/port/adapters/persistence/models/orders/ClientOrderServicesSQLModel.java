package com.freelance.skc.port.adapters.persistence.models.orders;

import com.freelance.skc.port.adapters.persistence.models.common.BaseListSQLModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ClientOrderServicesSQLModel implements BaseListSQLModel {

    public static final String table = "sc_client_order_services";

    public static final String clientOrderIdCol = "client_order_id";
    public static final String serviceIdCol = "service_id";

    @Override
    public @NotNull String mainIdCol() {
        return clientOrderIdCol;
    }

    @Override
    public @NotNull String valuesIdCol() {
        return serviceIdCol;
    }

    @Override
    public @NotNull String table() {
        return table;
    }
}