package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.OrderApplicationService;
import com.freelance.skc.application.rabbit.RabbitMQProducer;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderApplicationController {

    private final OrderApplicationService orderApplicationService;
    private final RabbitMQProducer rabbitMQProducer;

    public OrderApplicationController(OrderApplicationService orderApplicationService, RabbitMQProducer rabbitMQProducer) {
        this.orderApplicationService = orderApplicationService;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping("/api/order-applications")
    public void save(@RequestBody @NotNull OrderApplicationCreationRequest orderApplicationCreationRequest) {
        orderApplicationService.save(orderApplicationCreationRequest);
    }

    @PostMapping("/api/publish/order-applications")
    public void publish(@RequestBody @NotNull OrderApplicationCreationRequest orderApplicationCreationRequest) {
        rabbitMQProducer.sendOrderApplication(orderApplicationCreationRequest);
    }

    @DeleteMapping("/api/order-applications/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        orderApplicationService.delete(id);
    }

    @GetMapping("/api/order-applications")
    public List<OrderApplicationBackofficeModel> all(@RequestParam(name = "email", required = true) String email) {
        return orderApplicationService.all(email);
    }

}
