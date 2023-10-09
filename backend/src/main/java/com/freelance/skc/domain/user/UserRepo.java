package com.freelance.skc.domain.user;

import java.util.List;

public interface UserRepo {

    void save(User user);

    void delete(String userId);

    List<User> all();

}
