package com.freelance.skc.application.mappers.orders;

import com.freelance.skc.application.mappers.interfaces.DomainMapperWithTimeZone;
import com.freelance.skc.domain.orders.client.ClientOrder;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderUpdateRequest;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class ClientOrderMapper implements DomainMapperWithTimeZone<
        ClientOrder,
        ClientOrderBackofficeModel,
        ClientOrderCreationRequest,
        ClientOrderUpdateRequest
    > {


    public ClientOrderBackofficeModel mapToBackofficeModelWithTimeZone(ClientOrder entity, String callerTimeZone) {
        return new ClientOrderBackofficeModel(
                entity.id(),
                entity.clientId(),
                entity.title(),
                entity.description(),
                entity.serviceIds(),
                entity.orderType(),
                entity.status(),
                entity.endAt() != null ? entity.endAt().atZoneSameInstant(ZoneId.of(callerTimeZone)).toOffsetDateTime() : null
        );
    }

    @Override
    public ClientOrder of(ClientOrderCreationRequest creationRequest) {
        return ClientOrder.of(
                creationRequest.clientId(),
                creationRequest.title(),
                creationRequest.description(),
                creationRequest.serviceIds(),
                creationRequest.orderType(),
                creationRequest.endAt()
        );
    }

    @Override
    public ClientOrder newDomain(String id, ClientOrderUpdateRequest updateRequest) {
        return new ClientOrder(
                id,
                updateRequest.clientId(),
                updateRequest.title(),
                updateRequest.description(),
                updateRequest.serviceIds(),
                updateRequest.orderType(),
                updateRequest.status(),
                updateRequest.endAt()
        );
    }

}
