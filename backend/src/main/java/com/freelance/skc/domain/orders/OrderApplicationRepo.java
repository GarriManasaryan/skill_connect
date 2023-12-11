package com.freelance.skc.domain.orders;

import com.freelance.skc.application.validators.DomainRepoInterface;

import java.util.List;

public interface OrderApplicationRepo extends DomainRepoInterface<OrderApplication> {

    void save(OrderApplication orderApplication);

    void delete(String id);

    List<OrderApplication> all();

}
