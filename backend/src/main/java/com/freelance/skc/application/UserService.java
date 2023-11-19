package com.freelance.skc.application;

import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserDiscriminator;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.user.UserBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.user.UserCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void save(UserCreationRequest userCreationRequest) {
        userRepo.save(User.of(
                userCreationRequest.name(),
                userCreationRequest.email(),
                userCreationRequest.role(),
                userCreationRequest.age(),
                UserDiscriminator.valueOf(userCreationRequest.discriminator()),
                userCreationRequest.timeZone()
        ));
    }

    public void delete(String userId) {
        userRepo.delete(userId);
    }

    public List<UserBackofficeModel> all() {
        return userRepo.all().stream()
                .map(user -> new UserBackofficeModel(
                        user.id(),
                        user.name(),
                        user.email(),
                        user.role(),
                        user.age(),
                        user.discriminator(),
                        user.timeZone()
                ))
                .toList();
    }
}
