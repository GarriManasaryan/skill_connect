package com.freelance.skc.application;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.ProfileMapper;
import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService extends BaseService<Profile, ProfileBackofficeModel, ProfileCreationRequest, ProfileUpdateRequest, ProfileRepo, ProfileMapper> {

    public ProfileService(ProfileRepo repo, ProfileMapper mapper) {
        super(repo, mapper);
    }
}

