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

    @PostMapping("/api/services")
    public void save(@RequestBody @NotNull FreelanceServiceCreationRequest freelanceServiceCreationRequest) {
        freelanceServiceService.save(freelanceServiceCreationRequest);
    }

    @DeleteMapping("/api/services/{id}")
    public void delete(@PathVariable(name = "id", required = true) String id) {
        freelanceServiceService.delete(id);
    }

    @DeleteMapping("/api/services")
    public void deleteAll() {
        all().forEach((service) -> freelanceServiceService.delete(service.id()));
    }


    @GetMapping("/api/services")
    public List<FreelanceServiceBackofficeModel> all() {
        return freelanceServiceService.all();
    }

}
