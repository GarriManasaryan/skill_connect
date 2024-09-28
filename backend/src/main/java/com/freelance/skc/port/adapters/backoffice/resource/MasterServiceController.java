package com.freelance.skc.port.adapters.backoffice.resource;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.MasterServiceMapper;
import com.freelance.skc.domain.service.MasterService;
import com.freelance.skc.domain.service.MasterServiceRepo;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.service.MasterServiceUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/master-services")
public class MasterServiceController extends BaseController<MasterService, MasterServiceBackofficeModel, MasterServiceCreationRequest, MasterServiceUpdateRequest, MasterServiceRepo, MasterServiceMapper> {

    public MasterServiceController(BaseService<MasterService, MasterServiceBackofficeModel, MasterServiceCreationRequest, MasterServiceUpdateRequest, MasterServiceRepo, MasterServiceMapper> baseService) {
        super(baseService);
    }
}
