package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.FreelanceServiceService;
import com.freelance.skc.application.SkillService;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.skill.SkillCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/api/skills")
    public void save(@RequestBody @NotNull SkillCreationRequest skillCreationRequest) {
        skillService.save(skillCreationRequest);
    }

    @DeleteMapping("/api/skills/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        skillService.delete(id);
    }

    @GetMapping("/api/skills")
    public List<SkillBackofficeModel> all() {
        return skillService.all();
    }

}
