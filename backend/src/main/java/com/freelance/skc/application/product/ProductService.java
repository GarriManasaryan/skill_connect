package com.freelance.skc.application.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.ProductMapper;
import com.freelance.skc.domain.product.Product;
import com.freelance.skc.domain.product.ProductRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService extends BaseService<Product, ProductBackofficeModel, ProductCreationRequest, ProductUpdateRequest, ProductRepo, ProductMapper> {

    public ProductService(ProductRepo repo, ProductMapper mapper) {
        super(repo, mapper);
    }
}
