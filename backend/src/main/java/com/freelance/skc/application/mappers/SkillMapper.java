package com.freelance.skc.application.mappers;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.skill.Skill;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper implements DomainMapper<Skill, SkillBackofficeModel, SkillCreationRequest, SkillUpdateRequest> {

    @Override
    public SkillBackofficeModel mapToBackofficeModel(Skill entity) {
        return new SkillBackofficeModel(
                entity.id(),
                entity.name(),
                entity.description(),
                entity.parentId()
        );
    }

    @Override
    public Skill of(SkillCreationRequest creationRequest) {
        return Skill.of(
                creationRequest.name(),
                creationRequest.description(),
                creationRequest.parentId()
        );
    }

    @Override
    public Skill newDomain(String id, SkillUpdateRequest updateRequest) {
        return new Skill(
                id,
                updateRequest.name(),
                updateRequest.description(),
                updateRequest.parentId()
        );
    }

}
