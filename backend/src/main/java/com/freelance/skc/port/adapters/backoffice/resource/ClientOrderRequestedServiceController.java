package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.ClientOrderRequestedServiceService;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderFreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderFreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClientOrderRequestedServiceController {

    private final ClientOrderRequestedServiceService clientOrderRequestedServiceService;

    public ClientOrderRequestedServiceController(ClientOrderRequestedServiceService clientOrderRequestedServiceService) {
        this.clientOrderRequestedServiceService = clientOrderRequestedServiceService;
    }

    @PostMapping("/api/client-order-services")
    public void save(@RequestBody @NotNull ClientOrderFreelanceServiceCreationRequest clientOrderFreelanceServiceCreationRequest) {
        clientOrderRequestedServiceService.save(clientOrderFreelanceServiceCreationRequest);
    }

    @DeleteMapping("/api/client-order-services/{client_order_id}/{service_id}")
    public void delete(
            @PathVariable(name = "client_order_id", required = true) String clientOrderId,
            @PathVariable(name = "service_id", required = true) String serviceId
    ) {
        clientOrderRequestedServiceService.delete(clientOrderId, serviceId);
    }

    @GetMapping("/api/client-order-services")
    public List<ClientOrderFreelanceServiceBackofficeModel> all() {
        return clientOrderRequestedServiceService.all();
    }

}
