package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.FreelanceServiceService;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FreelanceServiceController {

    private final FreelanceServiceService freelanceServiceService;

    public FreelanceServiceController(FreelanceServiceService freelanceServiceService) {
        this.freelanceServiceService = freelanceServiceService;
    }

    @PostMapping("/api/service")
    public void save(@RequestBody @NotNull FreelanceServiceCreationRequest freelanceServiceCreationRequest) {
        freelanceServiceService.save(freelanceServiceCreationRequest);
    }

    @DeleteMapping("/api/service/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        freelanceServiceService.delete(id);
    }

    @GetMapping("/api/service")
    public List<FreelanceServiceBackofficeModel> all() {
        return freelanceServiceService.all();
    }

}
