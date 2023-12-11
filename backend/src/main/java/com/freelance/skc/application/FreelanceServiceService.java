package com.freelance.skc.application;

import com.freelance.skc.application.validation.FKCheckerV2;
import com.freelance.skc.application.validators.FKChecker;
import com.freelance.skc.domain.service.FreelanceService;
import com.freelance.skc.domain.service.FreelanceServiceRepo;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.FreelanceServiceCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FreelanceServiceService {

    private final FreelanceServiceRepo freelanceServiceRepo;
    private final FKChecker<FreelanceServiceRepo> fkChecker;

    public FreelanceServiceService(
            FreelanceServiceRepo freelanceServiceRepo,
            FKChecker<FreelanceServiceRepo> fkChecker
    ) {
        this.freelanceServiceRepo = freelanceServiceRepo;
        this.fkChecker = fkChecker;
    }

    public void save(@NotNull FreelanceServiceCreationRequest freelanceServiceCreationRequest) {
        var availableFreelanceServiceIds = freelanceServiceRepo.all().stream().map(FreelanceService::id).toList();
        if (freelanceServiceCreationRequest.parentId() != null && !availableFreelanceServiceIds.contains(freelanceServiceCreationRequest.parentId())) {
            throw new IllegalStateException("ParentId not found");
        }

        // validation
        fkChecker.validate(
                freelanceServiceRepo,
                freelanceServiceCreationRequest.parentId(),
                "parentId not found"
        );

        freelanceServiceRepo.save(FreelanceService.of(
                freelanceServiceCreationRequest.name(),
                freelanceServiceCreationRequest.description(),
                freelanceServiceCreationRequest.parentId()
        ));
    }

    public void delete(@NotNull String id) {
        freelanceServiceRepo.delete(id);
    }

    public List<FreelanceServiceBackofficeModel> all() {
        return freelanceServiceRepo.all().stream()
                .map(freelanceService -> new FreelanceServiceBackofficeModel(
                        freelanceService.id(),
                        freelanceService.name(),
                        freelanceService.description(),
                        freelanceService.parentId()
                ))
                .toList();
    }
}
