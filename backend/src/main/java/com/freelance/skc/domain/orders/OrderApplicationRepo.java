package com.freelance.skc.domain.orders;

import java.util.List;

public interface OrderApplicationRepo {

    void save(OrderApplication orderApplication);

    void delete(String id);

    List<OrderApplication> all();

}
