package com.freelance.skc.port.adapters.backoffice.resource.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.ClientOrderResponseMapper;
import com.freelance.skc.domain.orders.response.ClientOrderResponse;
import com.freelance.skc.domain.orders.response.ClientOrderResponseRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order-responses")
public class ClientOrderResponseController extends BaseController<
        ClientOrderResponse,
        ClientOrderResponseBackofficeModel,
        ClientOrderResponseCreationRequest,
        ClientOrderResponseUpdateRequest,
        ClientOrderResponseRepo,
        ClientOrderResponseMapper
    >
    {
    public ClientOrderResponseController(BaseService<ClientOrderResponse, ClientOrderResponseBackofficeModel, ClientOrderResponseCreationRequest, ClientOrderResponseUpdateRequest, ClientOrderResponseRepo, ClientOrderResponseMapper> baseService) {
        super(baseService);
    }
}
