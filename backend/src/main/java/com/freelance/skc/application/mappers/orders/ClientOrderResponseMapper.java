package com.freelance.skc.application.mappers.orders;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.orders.response.ClientOrderResponse;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientOrderResponseMapper implements DomainMapper<ClientOrderResponse, ClientOrderResponseBackofficeModel, ClientOrderResponseCreationRequest, ClientOrderResponseUpdateRequest> {

    @Override
    public ClientOrderResponseBackofficeModel mapToBackofficeModel(ClientOrderResponse entity) {
        return new ClientOrderResponseBackofficeModel(
                entity.id(),
                entity.profileId(),
                entity.clientOrderResponseStatus(),
                entity.appliedAt(),
                entity.applicationText(),
                entity.clientOrderId()
        );
    }

    @Override
    public ClientOrderResponse of(ClientOrderResponseCreationRequest creationRequest) {
        return ClientOrderResponse.of(
                creationRequest.profileId(),
                creationRequest.applicationText(),
                creationRequest.clientOrderId()
        );
    }

    @Override
    public ClientOrderResponse newDomain(String id, ClientOrderResponseUpdateRequest updateRequest) {
        return new ClientOrderResponse(
                id,
                updateRequest.profileId(),
                updateRequest.clientOrderResponseStatus(),
                updateRequest.appliedAt(),
                updateRequest.applicationText(),
                updateRequest.clientOrderId()
        );
    }

}
