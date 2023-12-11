package com.freelance.skc.domain.user;

import com.freelance.skc.application.validators.DomainRepoInterface;

import java.util.List;

public interface UserRepo extends DomainRepoInterface<User> {

    void save(User user);

    void delete(String userId);

    List<User> all();

}
