package com.freelance.skc.application;

import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepo profileRepo;

    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public void save(ProfileCreationRequest profileCreationRequest) {
        profileRepo.save(Profile.of(
                profileCreationRequest.title(),
                profileCreationRequest.description(),
                profileCreationRequest.userId()
        ));
    }

    public void delete(String id) {
        profileRepo.delete(id);
    }

    public List<ProfileBackofficeModel> all() {

        return profileRepo.all().stream()
                .map(profile -> new ProfileBackofficeModel(
                        profile.id(),
                        profile.title(),
                        profile.description(),
                        profile.userId()
                ))
                .toList();
    }
}

