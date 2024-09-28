package com.freelance.skc.application;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.MasterServiceMapper;
import com.freelance.skc.application.mappers.SkillMapper;
import com.freelance.skc.domain.service.MasterService;
import com.freelance.skc.domain.service.MasterServiceRepo;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MasterServiceService extends BaseService<MasterService, MasterServiceBackofficeModel, MasterServiceCreationRequest, MasterServiceUpdateRequest, MasterServiceRepo, MasterServiceMapper> {
    public MasterServiceService(MasterServiceRepo repo, MasterServiceMapper mapper) {
        super(repo, mapper);
    }
}
