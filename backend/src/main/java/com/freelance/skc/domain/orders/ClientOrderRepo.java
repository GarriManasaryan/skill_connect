package com.freelance.skc.domain.orders;

import com.freelance.skc.application.validators.DomainRepoInterface;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ClientOrderRepo extends DomainRepoInterface<ClientOrder> {

    void save(ClientOrder clientOrder);

    void delete(String id);

    @NotNull List<ClientOrder> all();

}
