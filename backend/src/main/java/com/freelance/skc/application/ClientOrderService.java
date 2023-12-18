package com.freelance.skc.application;

import com.freelance.skc.application.validators.FKChecker;
import com.freelance.skc.domain.orders.ClientOrder;
import com.freelance.skc.domain.orders.ClientOrderRepo;
import com.freelance.skc.domain.orders.OrderType;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.ClientOrderCreationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
public class ClientOrderService {

    private final ClientOrderRepo clientOrderRepo;
    private final FKChecker<UserRepo> fkUserChecker;
    private final UserRepo userRepo;
    private final FreelanceServiceRepo freelanceServiceRepo;

    public ClientOrderService(
            ClientOrderRepo clientOrderRepo,
            FKChecker<UserRepo> fkUserChecker,
            UserRepo userRepo,
            FreelanceServiceRepo freelanceServiceRepo
    ) {
        this.clientOrderRepo = clientOrderRepo;
        this.fkUserChecker = fkUserChecker;
        this.userRepo = userRepo;
        this.freelanceServiceRepo = freelanceServiceRepo;
    }

    public void save(ClientOrderCreationRequest clientOrderCreationRequest) {
        // validation
        fkUserChecker.validate(userRepo, clientOrderCreationRequest.clientId(), "user not found");

        // save
        clientOrderRepo.save(ClientOrder.of(
                clientOrderCreationRequest.clientId(),
                clientOrderCreationRequest.title(),
                clientOrderCreationRequest.description(),
                OrderType.stringToEnum(clientOrderCreationRequest.orderType()),
                clientOrderCreationRequest.endAt()
        ));
    }

    public void delete(String id) {
        clientOrderRepo.delete(id);
    }

    public List<ClientOrderBackofficeModel> all(String email) {
        var userTimeZone = userRepo.all().stream()
                .filter(user -> user.email().equals(email))
                .map(User::timeZone)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        return clientOrderRepo.all().stream()
                .map(order -> new ClientOrderBackofficeModel(
                        order.id(),
                        order.clientId(),
                        order.title(),
                        order.description(),
                        order.orderType(),
                        order.endAt() != null ? order.endAt().atZoneSameInstant(ZoneId.of(userTimeZone)).toOffsetDateTime() : null
                ))
                .toList();
    }
}
