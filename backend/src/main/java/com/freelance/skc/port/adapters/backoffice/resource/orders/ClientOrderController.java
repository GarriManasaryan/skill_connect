package com.freelance.skc.port.adapters.backoffice.resource.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.ClientOrderMapper;
import com.freelance.skc.application.orders.ClientOrderService;
import com.freelance.skc.domain.orders.client.ClientOrder;
import com.freelance.skc.domain.orders.client.ClientOrderRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/client-orders")
public class ClientOrderController extends BaseController<
        ClientOrder,
        ClientOrderBackofficeModel,
        ClientOrderCreationRequest,
        ClientOrderUpdateRequest,
        ClientOrderRepo,
        ClientOrderMapper
        > {

    private final ClientOrderService clientOrderService;

    public ClientOrderController(BaseService<ClientOrder, ClientOrderBackofficeModel, ClientOrderCreationRequest, ClientOrderUpdateRequest, ClientOrderRepo, ClientOrderMapper> baseService, ClientOrderService clientOrderService) {
        super(baseService);
        this.clientOrderService = clientOrderService;
    }

    @GetMapping("/user-tz/{email}")
    public List<ClientOrderBackofficeModel> allWithUserTimeZone(@PathVariable String email) {
        return clientOrderService.allWithUserTimeZone(email);
    }

    @GetMapping("/{id}/user-tz/{email}")
    public Optional<ClientOrderBackofficeModel> ofIdWithUserTimeZone(@PathVariable String id, @PathVariable String email) {
        return clientOrderService.ofIdWithUserTimeZone(id, email);
    }

}
