package com.freelance.skc.application;

import com.freelance.skc.domain.orders.OrderApplication;
import com.freelance.skc.domain.orders.OrderApplicationRepo;
import com.freelance.skc.domain.orders.OrderApplicationStatus;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.OrderApplicationCreationRequest;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;

@Service
public class OrderApplicationService {

    private final OrderApplicationRepo orderApplicationRepo;
    private final UserRepo userRepo;

    public OrderApplicationService(OrderApplicationRepo orderApplicationRepo, UserRepo userRepo) {
        this.orderApplicationRepo = orderApplicationRepo;
        this.userRepo = userRepo;
    }

    public void save(OrderApplicationCreationRequest orderApplicationCreationRequest) {
        orderApplicationRepo.save(OrderApplication.of(
                orderApplicationCreationRequest.profileId(),
                OrderApplicationStatus.valueOf(orderApplicationCreationRequest.orderApplicationStatus()),
                orderApplicationCreationRequest.appliedAt(),
                orderApplicationCreationRequest.applicationText(),
                orderApplicationCreationRequest.clientOrderId()
        ));
    }

    public void delete(String id) {
        orderApplicationRepo.delete(id);
    }

    public List<OrderApplicationBackofficeModel> all(String email) {
        var userTimeZone = userRepo.all().stream()
                .filter(user -> user.email().equals(email))
                .map(User::timeZone)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        return orderApplicationRepo.all().stream()
                .map(appl -> new OrderApplicationBackofficeModel(
                        appl.id(),
                        appl.profileId(),
                        appl.orderApplicationStatus(),
                        appl.appliedAt().atZoneSameInstant(ZoneId.of(userTimeZone)).toOffsetDateTime(),
                        appl.applicationText(),
                        appl.clientOrderId()
                ))
                .toList();
    }
}
