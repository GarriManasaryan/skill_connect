package com.freelance.skc.domain.profile;

import com.freelance.skc.application.common.validators.DomainRepoInterface;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProfileRepo extends DomainRepoInterface<Profile> {

//    void addPic(String profileId, MultipartFile file) throws IOException;

}
