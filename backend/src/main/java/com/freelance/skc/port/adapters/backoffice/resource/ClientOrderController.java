package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.ClientOrderService;
import com.freelance.skc.application.FreelanceServiceService;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClientOrderController {

    private final ClientOrderService clientOrderService;

    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @PostMapping("/api/client-order")
    public void save(@RequestBody @NotNull ClientOrderCreationRequest clientOrderCreationRequest) {
        clientOrderService.save(clientOrderCreationRequest);
    }

    @DeleteMapping("/api/client-order/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        clientOrderService.delete(id);
    }

    @GetMapping("/api/client-order")
    public List<ClientOrderBackofficeModel> all(@RequestParam(name = "email", required = true) String email) {
        return clientOrderService.all(email);
    }

}
