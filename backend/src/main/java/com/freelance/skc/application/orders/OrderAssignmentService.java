package com.freelance.skc.application.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.OrderAssignmentMapper;
import com.freelance.skc.domain.orders.assignment.OrderAssignment;
import com.freelance.skc.domain.orders.assignment.OrderAssignmentRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderAssignmentService extends BaseService<
        OrderAssignment,
        OrderAssignmentBackofficeModel,
        OrderAssignmentCreationRequest,
        OrderAssignmentUpdateRequest,
        OrderAssignmentRepo,
        OrderAssignmentMapper
        > {

    public OrderAssignmentService(OrderAssignmentRepo repo, OrderAssignmentMapper mapper) {
        super(repo, mapper);
    }
}
