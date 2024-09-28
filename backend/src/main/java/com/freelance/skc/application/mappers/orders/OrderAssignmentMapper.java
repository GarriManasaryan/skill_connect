package com.freelance.skc.application.mappers.orders;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.orders.assignment.OrderAssignment;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderAssignmentMapper implements DomainMapper<OrderAssignment, OrderAssignmentBackofficeModel, OrderAssignmentCreationRequest, OrderAssignmentUpdateRequest> {

    @Override
    public OrderAssignmentBackofficeModel mapToBackofficeModel(OrderAssignment entity) {
        return new OrderAssignmentBackofficeModel(
                entity.id(),
                entity.clientId(),
                entity.profileId(),
                entity.startAt().orElse(null),
                entity.endAt().orElse(null)
        );
    }

    @Override
    public OrderAssignment of(OrderAssignmentCreationRequest creationRequest) {
        return OrderAssignment.of(
                creationRequest.clientId(),
                creationRequest.profileId(),
                creationRequest.startAt(),
                creationRequest.endAt()
        );
    }

    @Override
    public OrderAssignment newDomain(String id, OrderAssignmentUpdateRequest updateRequest) {
        return new OrderAssignment(
                id,
                updateRequest.clientId(),
                updateRequest.profileId(),
                Optional.ofNullable(updateRequest.startAt()),
                Optional.ofNullable(updateRequest.endAt())
        );
    }

}
