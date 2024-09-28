package com.freelance.skc.application.orders;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.orders.ClientOrderResponseMapper;
import com.freelance.skc.domain.orders.response.ClientOrderResponse;
import com.freelance.skc.domain.orders.response.ClientOrderResponseRepo;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientOrderResponseService extends BaseService<ClientOrderResponse, ClientOrderResponseBackofficeModel, ClientOrderResponseCreationRequest, ClientOrderResponseUpdateRequest, ClientOrderResponseRepo, ClientOrderResponseMapper> {
    public ClientOrderResponseService(ClientOrderResponseRepo repo, ClientOrderResponseMapper mapper) {
        super(repo, mapper);
    }

//    @Override
//    public void save(@NotNull ClientOrderResponseCreationRequest creationRequest) {
////        fkProfileChecker.validate(profileRepo, clientOrderResponseCreationRequest.profileId(), "profile not found");
////        fkUserChecker.validate(userRepo, clientOrderResponseCreationRequest.clientOrderId(), "client not found");
//
//        super.save(creationRequest);
//    }
}
