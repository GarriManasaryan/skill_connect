package com.freelance.skc.domain.profile;

import com.freelance.skc.application.validators.DomainInterface;
import com.freelance.skc.application.validators.DomainRepoInterface;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProfileRepo extends DomainRepoInterface<Profile> {

    void save(Profile profile);

    void delete(String id);

    List<Profile> all();

    Optional<Profile> ofId(String id);

    void addPic(String profileId, MultipartFile file) throws IOException;

    void patchDescription(String profileId, String description);

    void patchTitle(String profileId, String title);

}
