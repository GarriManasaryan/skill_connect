package com.freelance.skc.domain.orders;

import java.util.List;

public interface ClientOrderRepo {

    void save(ClientOrder clientOrder);

    void delete(String id);

    List<ClientOrder> all();

}
