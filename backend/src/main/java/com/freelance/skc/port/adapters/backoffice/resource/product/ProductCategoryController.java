package com.freelance.skc.port.adapters.backoffice.resource.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.ProductCategoryMapper;
import com.freelance.skc.domain.product.category.ProductCategory;
import com.freelance.skc.domain.product.category.ProductCategoryRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.category.ProductCategoryUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product-categories")
public class ProductCategoryController extends BaseController<ProductCategory, ProductCategoryBackofficeModel, ProductCategoryCreationRequest, ProductCategoryUpdateRequest, ProductCategoryRepo, ProductCategoryMapper> {

    public ProductCategoryController(BaseService<ProductCategory, ProductCategoryBackofficeModel, ProductCategoryCreationRequest, ProductCategoryUpdateRequest, ProductCategoryRepo, ProductCategoryMapper> baseService) {
        super(baseService);
    }
}
