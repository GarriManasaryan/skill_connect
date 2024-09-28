package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.ProfileMapper;
import com.freelance.skc.domain.profile.Profile;
import com.freelance.skc.domain.profile.ProfileRepo;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.profile.ProfileUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/profiles")
public class ProfileController extends BaseController<Profile, ProfileBackofficeModel, ProfileCreationRequest, ProfileUpdateRequest, ProfileRepo, ProfileMapper> {

    public ProfileController(BaseService<Profile, ProfileBackofficeModel, ProfileCreationRequest, ProfileUpdateRequest, ProfileRepo, ProfileMapper> baseService) {
        super(baseService);
    }
}
