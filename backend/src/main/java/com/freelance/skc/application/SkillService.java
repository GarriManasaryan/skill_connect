package com.freelance.skc.application;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.SkillMapper;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillUpdateRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService extends BaseService<Skill, SkillBackofficeModel, SkillCreationRequest, SkillUpdateRequest, SkillRepo, SkillMapper> {

    public SkillService(SkillRepo repo, SkillMapper mapper) {
        super(repo, mapper);
    }
}
