package com.freelance.skc.application.mappers;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper implements DomainMapper<Profile, ProfileBackofficeModel, ProfileCreationRequest, ProfileUpdateRequest> {

    @Override
    public ProfileBackofficeModel mapToBackofficeModel(Profile profile) {
        return new ProfileBackofficeModel(
                profile.id(),
                profile.title(),
                profile.description(),
                profile.userId(),
                profile.skillIds(),
                profile.serviceIds()
        );
    }

    public Profile of(ProfileCreationRequest creationRequest) {
        return Profile.of(
                creationRequest.title(),
                creationRequest.description(),
                creationRequest.userId(),
                creationRequest.skillIds(),
                creationRequest.serviceIds()
        );
    }

    @Override
    public Profile newDomain(String id, ProfileUpdateRequest updateRequest) {
        return new Profile(
                id,
                updateRequest.title(),
                updateRequest.description(),
                updateRequest.userId(),
                updateRequest.skillIds(),
                updateRequest.serviceIds()
        );
    }

}
