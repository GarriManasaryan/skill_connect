package com.freelance.skc.application.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.ClientOrderMapper;
import com.freelance.skc.domain.orders.client.ClientOrder;
import com.freelance.skc.domain.orders.client.ClientOrderRepo;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.client.ClientOrderUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientOrderService extends BaseService<
        ClientOrder,
        ClientOrderBackofficeModel,
        ClientOrderCreationRequest,
        ClientOrderUpdateRequest,
        ClientOrderRepo,
        ClientOrderMapper
        > {

    private final UserRepo userRepo;

    public ClientOrderService(ClientOrderRepo repo, ClientOrderMapper mapper, UserRepo userRepo) {
        super(repo, mapper);
        this.userRepo = userRepo;
    }

    public List<ClientOrderBackofficeModel> allWithUserTimeZone(String email) {
        var userTimeZone = userRepo.all().stream()
                .filter(user -> user.email().equals(email))
                .map(User::timeZone)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        return super.getRepo()
                .all()
                .stream()
                .map(entity -> super.getMapper().mapToBackofficeModelWithTimeZone(entity, userTimeZone))
                .toList();
    }

    public Optional<ClientOrderBackofficeModel> ofIdWithUserTimeZone(String id, String email) {
        var userTimeZone = userRepo.all().stream()
                .filter(user -> user.email().equals(email))
                .map(User::timeZone)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        return super.getRepo()
                .ofId(id)
                .map(entity -> super.getMapper().mapToBackofficeModelWithTimeZone(entity, userTimeZone));
    }

}
