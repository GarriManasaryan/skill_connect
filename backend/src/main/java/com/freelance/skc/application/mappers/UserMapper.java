package com.freelance.skc.application.mappers;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.port.adapters.backoffice.model.user.UserBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.user.UserCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.user.UserUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DomainMapper<User, UserBackofficeModel, UserCreationRequest, UserUpdateRequest> {

    @Override
    public UserBackofficeModel mapToBackofficeModel(User user) {
        return new UserBackofficeModel(
                user.id(),
                user.name(),
                user.email(),
                user.role(),
                user.age(),
                user.discriminator(),
                user.timeZone()
        );
    }

    @Override
    public User of(UserCreationRequest creationRequest) {
        return User.of(
                creationRequest.name(),
                creationRequest.email(),
                creationRequest.role(),
                creationRequest.age(),
                creationRequest.discriminator(),
                creationRequest.timeZone()
        );
    }

    @Override
    public User newDomain(String id, UserUpdateRequest updateRequest) {
        return new User(
                id,
                updateRequest.name(),
                updateRequest.email(),
                updateRequest.role(),
                updateRequest.age(),
                updateRequest.discriminator(),
                updateRequest.timeZone()
        );
    }

}
