package com.freelance.skc.application.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.ProductCategoryMapper;
import com.freelance.skc.domain.product.category.ProductCategory;
import com.freelance.skc.domain.product.category.ProductCategoryRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductCategoryService extends BaseService<ProductCategory, ProductCategoryBackofficeModel, ProductCategoryCreationRequest, ProductCategoryUpdateRequest, ProductCategoryRepo, ProductCategoryMapper> {

    public ProductCategoryService(ProductCategoryRepo repo, ProductCategoryMapper mapper) {
        super(repo, mapper);
    }
}
