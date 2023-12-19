package com.freelance.skc.application;

import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.domain.user.User;
import com.freelance.skc.domain.user.UserRepo;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
                profileCreationRequest.sellerPic(),
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
                        profile.sellerPic(),
                        profile.userId()
                ))
                .toList();
    }

    public Optional<ProfileBackofficeModel> ofId(String id) {
        return profileRepo.ofId(id)
                .map(profile -> new ProfileBackofficeModel(
                        profile.id(),
                        profile.title(),
                        profile.description(),
                        profile.sellerPic(),
                        profile.userId()
                ))
                .stream().findFirst();
    }

    public void addPic(String id, MultipartFile file) throws IOException {
        profileRepo.addPic(id, file);
    }
}

