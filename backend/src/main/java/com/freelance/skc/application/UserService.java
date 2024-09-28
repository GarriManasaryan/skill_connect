package com.freelance.skc.application;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.UserMapper;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserDiscriminator;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.user.UserBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.user.UserCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.user.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<User, UserBackofficeModel, UserCreationRequest, UserUpdateRequest, UserRepo, UserMapper> {

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        super(userRepo, userMapper);
    }

}
