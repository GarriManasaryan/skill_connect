package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.FreelanceServiceService;
import com.freelance.skc.application.ProfileService;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/api/profile")
    public void save(@RequestBody @NotNull ProfileCreationRequest profileCreationRequest) {
        profileService.save(profileCreationRequest);
    }

    @DeleteMapping("/api/profile/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        profileService.delete(id);
    }

    @GetMapping("/api/profile")
    public List<ProfileBackofficeModel> all() {
        return profileService.all();
    }

}
