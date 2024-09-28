package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.UserService;
import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.UserMapper;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.user.UserBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.user.UserCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.user.UserUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController extends BaseController<User, UserBackofficeModel, UserCreationRequest, UserUpdateRequest, UserRepo, UserMapper> {

    public UserController(BaseService<User, UserBackofficeModel, UserCreationRequest, UserUpdateRequest, UserRepo, UserMapper> baseService) {
        super(baseService);
    }
}
