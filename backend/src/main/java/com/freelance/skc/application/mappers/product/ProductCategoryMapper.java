package com.freelance.skc.application.mappers.product;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.product.category.ProductCategory;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements DomainMapper<ProductCategory, ProductCategoryBackofficeModel, ProductCategoryCreationRequest, ProductCategoryUpdateRequest> {

    @Override
    public ProductCategoryBackofficeModel mapToBackofficeModel(ProductCategory entity) {
        return new ProductCategoryBackofficeModel(
                entity.id(),
                entity.name(),
                entity.description(),
                entity.parentId()
        );
    }

    @Override
    public ProductCategory of(ProductCategoryCreationRequest creationRequest) {
        return ProductCategory.of(
                creationRequest.name(),
                creationRequest.description(),
                creationRequest.parentId()
        );
    }

    @Override
    public ProductCategory newDomain(String id, ProductCategoryUpdateRequest updateRequest) {
        return new ProductCategory(
                id,
                updateRequest.name(),
                updateRequest.description(),
                updateRequest.parentId()
        );
    }

}
