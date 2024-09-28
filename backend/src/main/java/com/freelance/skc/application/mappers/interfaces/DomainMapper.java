package com.freelance.skc.application.mappers.interfaces;

import com.freelance.skc.application.common.validators.DomainInterface;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;

public interface DomainMapper<
        D extends DomainInterface,
        B extends BaseBackofficeModel,
        C extends BaseCreationRequest,
        U extends BaseUpdateRequest
    > {

    B mapToBackofficeModel(D domain);

    D of(C creationRequest);

    D newDomain(String id, U creationRequest);

}
