package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.ClientOrderService;
import com.freelance.skc.application.OrderApplicationService;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderApplicationController {

    private final OrderApplicationService orderApplicationService;

    public OrderApplicationController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping("/api/order-application")
    public void save(@RequestBody @NotNull OrderApplicationCreationRequest orderApplicationCreationRequest) {
        orderApplicationService.save(orderApplicationCreationRequest);
    }

    @DeleteMapping("/api/order-application/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        orderApplicationService.delete(id);
    }

    @GetMapping("/api/order-application")
    public List<OrderApplicationBackofficeModel> all(@RequestParam(name = "email", required = true) String email) {
        return orderApplicationService.all(email);
    }

}
