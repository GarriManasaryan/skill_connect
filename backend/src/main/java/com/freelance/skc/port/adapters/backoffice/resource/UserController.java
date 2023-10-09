package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.UserService;
import com.freelance.skc.port.adapters.backoffice.model.user.UserBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.user.UserCreationRequest;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public void save(@RequestBody UserCreationRequest userCreationRequest) {
        userService.save(userCreationRequest);
    }

    @DeleteMapping("/api/users/{userId}")
    public void delete(@PathVariable(name = "userId", required = true) String userId) {
        userService.delete(userId);
    }

    @GetMapping("/api/users")
    public List<UserBackofficeModel> all() {
        return userService.all();
    }
}
