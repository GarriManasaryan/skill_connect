package com.freelance.skc.application;

import com.freelance.skc.application.validators.FKChecker;
import com.freelance.skc.domain.orders.ClientOrderRequestedServiceRepo;
import com.freelance.skc.domain.orders.ClientOrderRepo;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderFreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderFreelanceServiceCreationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientOrderRequestedServiceService {

    private final ClientOrderRequestedServiceRepo clientOrderRequestedServiceRepo;
    private final FKChecker<ClientOrderRepo> fkCheckerClientOrder;
    private final FKChecker<FreelanceServiceRepo> fkCheckerFreelanceService;
    private final FreelanceServiceRepo freelanceServiceRepo;
    private final ClientOrderRepo clientOrderRepo;

    public ClientOrderRequestedServiceService(
            ClientOrderRequestedServiceRepo clientOrderRequestedServiceRepo,
            FKChecker<ClientOrderRepo> fkCheckerClientOrder,
            FKChecker<FreelanceServiceRepo> fkCheckerFreelanceService,
            FreelanceServiceRepo freelanceServiceRepo,
            ClientOrderRepo clientOrderRepo
    ) {
        this.clientOrderRequestedServiceRepo = clientOrderRequestedServiceRepo;
        this.fkCheckerClientOrder = fkCheckerClientOrder;
        this.fkCheckerFreelanceService = fkCheckerFreelanceService;
        this.freelanceServiceRepo = freelanceServiceRepo;
        this.clientOrderRepo = clientOrderRepo;
    }

    public void save(ClientOrderFreelanceServiceCreationRequest clientOrderFreelanceServiceCreationRequest) {
        // validation
        fkCheckerClientOrder.validate(clientOrderRepo, clientOrderFreelanceServiceCreationRequest.clientOrderId(), "order not found");
        fkCheckerFreelanceService.validate(freelanceServiceRepo, clientOrderFreelanceServiceCreationRequest.serviceId(), "service not found");

        // save
        clientOrderRequestedServiceRepo.save(
                clientOrderFreelanceServiceCreationRequest.clientOrderId(),
                clientOrderFreelanceServiceCreationRequest.serviceId()
        );
    }

    public void delete(String clientOrderId, String serviceId) {
        clientOrderRequestedServiceRepo.delete(clientOrderId, serviceId);
    }

    public List<ClientOrderFreelanceServiceBackofficeModel> all() {

        return clientOrderRequestedServiceRepo.all().stream()
                .map(order -> new ClientOrderFreelanceServiceBackofficeModel(
                        order.clientOrderId(),
                        order.serviceId()
                ))
                .toList();
    }
}
