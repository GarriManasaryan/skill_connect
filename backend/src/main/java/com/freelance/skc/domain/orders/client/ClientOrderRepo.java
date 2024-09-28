package com.freelance.skc.domain.orders.client;

import com.freelance.skc.application.common.validators.DomainRepoInterface;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface ClientOrderRepo extends DomainRepoInterface<ClientOrder> {

}
