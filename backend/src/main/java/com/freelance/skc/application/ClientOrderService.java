package com.freelance.skc.application;

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

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
public class ClientOrderService {

    private final ClientOrderRepo clientOrderRepo;
    private final UserRepo userRepo;
    private final FreelanceServiceRepo freelanceServiceRepo;

    public ClientOrderService(ClientOrderRepo clientOrderRepo, UserRepo userRepo, FreelanceServiceRepo freelanceServiceRepo) {
        this.clientOrderRepo = clientOrderRepo;
        this.userRepo = userRepo;
        this.freelanceServiceRepo = freelanceServiceRepo;
    }

    public void save(ClientOrderCreationRequest clientOrderCreationRequest) {
        clientOrderRepo.save(ClientOrder.of(
                clientOrderCreationRequest.clientId(),
                clientOrderCreationRequest.title(),
                clientOrderCreationRequest.description(),
                clientOrderCreationRequest.serviceId(),
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
                        order.serviceId(),
                        order.orderType(),
                        order.endAt() != null ? order.endAt().atZoneSameInstant(ZoneId.of(userTimeZone)).toOffsetDateTime() : null
                ))
                .toList();
    }
}
