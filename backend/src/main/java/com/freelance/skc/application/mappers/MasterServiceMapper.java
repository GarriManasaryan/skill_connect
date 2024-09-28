package com.freelance.skc.application.mappers;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.service.MasterService;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class MasterServiceMapper implements DomainMapper<MasterService, MasterServiceBackofficeModel, MasterServiceCreationRequest, MasterServiceUpdateRequest> {

    @Override
    public MasterServiceBackofficeModel mapToBackofficeModel(MasterService masterService) {
        return new MasterServiceBackofficeModel(
                masterService.id(),
                masterService.name(),
                masterService.description(),
                masterService.parentId()
        );
    }

    @Override
    public MasterService of(MasterServiceCreationRequest creationRequest) {
        return MasterService.of(
                creationRequest.name(),
                creationRequest.description(),
                creationRequest.parentId()
        );
    }

    @Override
    public MasterService newDomain(String id, MasterServiceUpdateRequest updateRequest) {
        return new MasterService(
                id,
                updateRequest.name(),
                updateRequest.description(),
                updateRequest.parentId()
        );
    }

}
