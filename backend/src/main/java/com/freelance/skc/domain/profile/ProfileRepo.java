package com.freelance.skc.domain.profile;

import java.util.List;

public interface ProfileRepo {

    void save(Profile profile);

    void delete(String id);

    List<Profile> all();

}
