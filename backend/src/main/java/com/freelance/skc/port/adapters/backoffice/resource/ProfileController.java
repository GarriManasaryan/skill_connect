package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.FreelanceServiceService;
import com.freelance.skc.application.ProfileService;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/api/profiles")
    public void save(@RequestBody @NotNull ProfileCreationRequest profileCreationRequest) {
        profileService.save(profileCreationRequest);
    }

    @DeleteMapping("/api/profiles/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        profileService.delete(id);
    }

    @GetMapping("/api/profiles")
    public List<ProfileBackofficeModel> all() {
        return profileService.all();
    }

    @GetMapping("/api/profiles/pic/{profile_id}")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable("profile_id") String id) {
        var profile = profileService.ofId(id);

        return profile
                .map(prof ->
                        ResponseEntity.ok()
                                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + prof.title() + "\"")
                                .contentType(MediaType.IMAGE_PNG)
                                .body(prof.sellerPic()))
                .orElse(null);
    }

    @PostMapping(value = "/api/profiles/pic")
    public void savePic(
            @RequestParam("file") MultipartFile file,
            @RequestParam("profile_id") String id
    ) throws IOException {
        profileService.addPic(id, file);
    }


}
