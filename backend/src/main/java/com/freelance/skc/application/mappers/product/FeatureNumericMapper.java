package com.freelance.skc.application.mappers.product;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.product.category.ProductCategory;
import com.freelance.skc.domain.product.feature.FeatureNumeric;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureNumericMapper implements DomainMapper<FeatureNumeric, FeatureNumericBackofficeModel, FeatureNumericCreationRequest, FeatureNumericUpdateRequest> {

    @Override
    public FeatureNumericBackofficeModel mapToBackofficeModel(FeatureNumeric entity) {
        return new FeatureNumericBackofficeModel(
                entity.id(),
                entity.name(),
                entity.description().orElse(null),
                entity.parentId().orElse(null),
                entity.categoryIds(),
                entity.from(),
                entity.to().orElse(null),
                entity.unit().orElse(null),
                entity.lessThanText().orElse(null),
                entity.moreThanText().orElse(null)
        );
    }

    @Override
    public FeatureNumeric of(FeatureNumericCreationRequest creationRequest) {
        return FeatureNumeric.of(
                creationRequest.name(),
                creationRequest.description(),
                creationRequest.parentId(),
                creationRequest.categoryIds(),
                creationRequest.from(),
                creationRequest.to(),
                creationRequest.unit(),
                creationRequest.lessThanText(),
                creationRequest.moreThanText()
        );
    }

    @Override
    public FeatureNumeric newDomain(String id, FeatureNumericUpdateRequest updateRequest) {
        return new FeatureNumeric(
                id,
                updateRequest.name(),
                Optional.ofNullable(updateRequest.description()),
                Optional.ofNullable(updateRequest.parentId()),
                updateRequest.categoryIds(),
                updateRequest.from(),
                Optional.ofNullable(updateRequest.to()),
                Optional.ofNullable(updateRequest.unit()),
                Optional.ofNullable(updateRequest.lessThanText()),
                Optional.ofNullable(updateRequest.moreThanText())
        );
    }

}
