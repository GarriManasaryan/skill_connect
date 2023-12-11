package com.freelance.skc.domain.skill;

import com.freelance.skc.application.validation.DomainRepoIntV2;
import com.freelance.skc.application.validators.DomainRepoInterface;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface SkillRepo extends DomainRepoInterface<Skill> {

    void save(@NotNull Skill skill);

    void delete(@NotNull String id);

    @NotNull List<Skill> all();

}
