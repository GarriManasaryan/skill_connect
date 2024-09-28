package com.freelance.skc.application.mappers.product;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.product.feature.FeatureText;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureTextMapper implements DomainMapper<FeatureText, FeatureTextBackofficeModel, FeatureTextCreationRequest, FeatureTextUpdateRequest> {

    @Override
    public FeatureTextBackofficeModel mapToBackofficeModel(FeatureText entity) {
        return new FeatureTextBackofficeModel(
                entity.id(),
                entity.name(),
                entity.description().orElse(null),
                entity.parentId().orElse(null),
                entity.categoryIds(),
                entity.value()
        );
    }

    @Override
    public FeatureText of(FeatureTextCreationRequest creationRequest) {
        return FeatureText.of(
                creationRequest.name(),
                creationRequest.description(),
                creationRequest.parentId(),
                creationRequest.categoryIds(),
                creationRequest.value()
        );
    }

    @Override
    public FeatureText newDomain(String id, FeatureTextUpdateRequest updateRequest) {
        return new FeatureText(
                id,
                updateRequest.name(),
                Optional.ofNullable(updateRequest.description()),
                Optional.ofNullable(updateRequest.parentId()),
                updateRequest.categoryIds(),
                updateRequest.value()
        );
    }

}
