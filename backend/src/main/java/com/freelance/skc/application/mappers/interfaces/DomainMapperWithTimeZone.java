package com.freelance.skc.application.mappers.interfaces;

import com.freelance.skc.application.common.validators.DomainInterface;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;

public interface DomainMapperWithTimeZone<
        D extends DomainInterface,
        B extends BaseBackofficeModel,
        C extends BaseCreationRequest,
        U extends BaseUpdateRequest
    > extends DomainMapper<D, B, C, U> {

    // нам нужно сделать более сложный mapToBackofficeModel маппер, но не хочется трогать другие базовые методы
    // наследуемся от базового и метод, ктоорый не нужен, просто объявляем дефолт с throws + еще можно deprecated обозначить
    @Deprecated
    default B mapToBackofficeModel(D domain){
        throw new UnsupportedOperationException("Not supported operation: following entity should be retrieved using mapToBackofficeModelWithTimeZone, not default mapToBackofficeModel");
    }

    B mapToBackofficeModelWithTimeZone(D domain, String callerTimeZone);

}
