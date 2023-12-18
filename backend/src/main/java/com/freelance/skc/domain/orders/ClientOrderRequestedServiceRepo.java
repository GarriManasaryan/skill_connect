package com.freelance.skc.domain.orders;

import java.util.List;

public interface ClientOrderRequestedServiceRepo {

    void save(String clientOrderId, String serviceId);

    void delete(String clientOrderId, String serviceId);

    List<ClientOrderRequestedService> all();

}
