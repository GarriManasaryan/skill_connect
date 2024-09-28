package com.freelance.skc.application.mappers.product;

import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.domain.product.Product;
import com.freelance.skc.domain.product.price.Price;
import com.freelance.skc.port.adapters.backoffice.model.product.product.PriceBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper implements DomainMapper<Product, ProductBackofficeModel, ProductCreationRequest, ProductUpdateRequest> {

    @Override
    public ProductBackofficeModel mapToBackofficeModel(Product entity) {
        return new ProductBackofficeModel(
                entity.id(),
                entity.name(),
                entity.description().orElse(null),
                new PriceBackofficeModel(
                        entity.price().value(),
                        entity.price().currency(),
                        entity.price().discount().orElse(null)
                ),
                entity.masterId(),
                entity.categoryIds(),
                entity.featureIds()
        );
    }

    @Override
    public Product of(ProductCreationRequest creationRequest) {
        return Product.of(
                creationRequest.name(),
                creationRequest.description(),
                new Price(
                        creationRequest.price().value(),
                        creationRequest.price().currency(),
                        Optional.ofNullable(creationRequest.price().discount())
                ),
                creationRequest.masterId(),
                creationRequest.categoryIds(),
                creationRequest.featureIds()
        );
    }

    @Override
    public Product newDomain(String id, ProductUpdateRequest updateRequest) {
        return new Product(
                id,
                updateRequest.name(),
                Optional.ofNullable(updateRequest.description()),
                new Price(
                        updateRequest.price().value(),
                        updateRequest.price().currency(),
                        Optional.ofNullable(updateRequest.price().discount())
                ),
                updateRequest.masterId(),
                updateRequest.categoryIds(),
                updateRequest.featureIds()
        );
    }

}
