package com.freelance.skc.domain.profile;

import com.freelance.skc.application.validators.DomainInterface;
import com.freelance.skc.application.validators.DomainRepoInterface;

import java.util.List;

public interface ProfileRepo extends DomainRepoInterface<Profile> {

    void save(Profile profile);

    void delete(String id);

    List<Profile> all();

}
