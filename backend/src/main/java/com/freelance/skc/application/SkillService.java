package com.freelance.skc.application;

import com.freelance.skc.application.validation.FKCheckerV2;
import com.freelance.skc.domain.service.FreelanceService;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.domain.skill.SkillRepo;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService {

    private final SkillRepo skillRepo;


    public SkillService(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    public void save(@NotNull SkillCreationRequest skillCreationRequest) {
        skillRepo.save(Skill.of(
                skillCreationRequest.name(),
                skillCreationRequest.description(),
                skillCreationRequest.parentId()
        ));
    }

    public void delete(@NotNull String id) {
        skillRepo.delete(id);
    }

    public List<SkillBackofficeModel> all() {
        return skillRepo.all().stream()
                .map(skill -> new SkillBackofficeModel(
                        skill.id(),
                        skill.name(),
                        skill.description(),
                        skill.parentId()
                ))
                .toList();
    }
}
