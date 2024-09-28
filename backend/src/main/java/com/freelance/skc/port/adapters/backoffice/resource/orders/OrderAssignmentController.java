package com.freelance.skc.port.adapters.backoffice.resource.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.OrderAssignmentMapper;
import com.freelance.skc.domain.orders.assignment.OrderAssignment;
import com.freelance.skc.domain.orders.assignment.OrderAssignmentRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.assignment.OrderAssignmentUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order-assignments")
public class OrderAssignmentController extends BaseController<
        OrderAssignment,
        OrderAssignmentBackofficeModel,
        OrderAssignmentCreationRequest,
        OrderAssignmentUpdateRequest,
        OrderAssignmentRepo,
        OrderAssignmentMapper
        > {

    public OrderAssignmentController(BaseService<OrderAssignment, OrderAssignmentBackofficeModel, OrderAssignmentCreationRequest, OrderAssignmentUpdateRequest, OrderAssignmentRepo, OrderAssignmentMapper> baseService) {
        super(baseService);
    }
}
