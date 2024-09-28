package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.SkillMapper;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/skills")
public class SkillController extends BaseController<Skill, SkillBackofficeModel, SkillCreationRequest, SkillUpdateRequest, SkillRepo, SkillMapper> {

    public SkillController(BaseService<Skill, SkillBackofficeModel, SkillCreationRequest, SkillUpdateRequest, SkillRepo, SkillMapper> baseService) {
        super(baseService);
    }

}
