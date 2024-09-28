//package com.freelance.skc.application.orders;
//
//import com.freelance.skc.application.common.validators.FKChecker;
//import com.freelance.skc.domain.orders.response.ClientOrderResponse;
//import com.freelance.skc.domain.orders.response.ClientOrderResponseRepo;
//import com.freelance.skc.domain.profile.ProfileRepo;
//import com.freelance.skc.domain.user.User;
//import com.freelance.skc.domain.user.UserRepo;
//import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseBackofficeModel;
//import com.freelance.skc.port.adapters.backoffice.model.orders.response.ClientOrderResponseCreationRequest;
//import org.springframework.stereotype.Service;
//
//import java.time.ZoneId;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClientOrderResponseServiceFK {
//
//    private final ClientOrderResponseRepo clientOrderResponseRepo;
//    private final UserRepo userRepo;
//    private final ProfileRepo profileRepo;
//    private final FKChecker<ProfileRepo> fkProfileChecker;
//    private final FKChecker<UserRepo> fkUserChecker;
//
//    public ClientOrderResponseServiceFK(
//            ClientOrderResponseRepo clientOrderResponseRepo,
//            ProfileRepo profileRepo,
//            FKChecker<ProfileRepo> fkProfileChecker,
//            FKChecker<UserRepo> fkUserChecker,
//            UserRepo userRepo
//    ) {
//        this.clientOrderResponseRepo = clientOrderResponseRepo;
//        this.userRepo = userRepo;
//        this.profileRepo = profileRepo;
//        this.fkProfileChecker = fkProfileChecker;
//        this.fkUserChecker = fkUserChecker;
//    }
//
//    public void save(ClientOrderResponseCreationRequest clientOrderResponseCreationRequest) {
//        // validation
//        fkProfileChecker.validate(profileRepo, clientOrderResponseCreationRequest.profileId(), "profile not found");
//        fkUserChecker.validate(userRepo, clientOrderResponseCreationRequest.clientOrderId(), "client not found");
//
//        // save
//        clientOrderResponseRepo.save(ClientOrderResponse.of(
//                clientOrderResponseCreationRequest.profileId(),
//                clientOrderResponseCreationRequest.applicationText(),
//                clientOrderResponseCreationRequest.clientOrderId()
//        ));
//    }
//
//    public void delete(String id) {
//        clientOrderResponseRepo.delete(id);
//    }
//
//    public List<ClientOrderResponseBackofficeModel> all(String email) {
//        var userTimeZone = userRepo.all().stream()
//                .filter(user -> user.email().equals(email))
//                .map(User::timeZone)
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("User not found"));
//
//        return clientOrderResponseRepo.all().stream()
//                .map(appl -> new ClientOrderResponseBackofficeModel(
//                        appl.id(),
//                        appl.profileId(),
//                        appl.clientOrderResponseStatus(),
//                        appl.appliedAt().atZoneSameInstant(ZoneId.of(userTimeZone)).toOffsetDateTime(),
//                        appl.applicationText(),
//                        appl.clientOrderId()
//                ))
//                .toList();
//    }
//
//    public Optional<ClientOrderResponseBackofficeModel> ofId(String id) {
//        return clientOrderResponseRepo.ofId(id).map(clientOrderResponse -> new ClientOrderResponseBackofficeModel(
//                clientOrderResponse.id(),
//                clientOrderResponse.profileId(),
//                clientOrderResponse.clientOrderResponseStatus(),
//                clientOrderResponse.appliedAt(),
//                clientOrderResponse.applicationText(),
//                clientOrderResponse.clientOrderId()
//        )).stream().findFirst();
//    }
//
//}
