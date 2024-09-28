package com.freelance.skc.port.adapters.backoffice.resource.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.ProductMapper;
import com.freelance.skc.domain.product.Product;
import com.freelance.skc.domain.product.ProductRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController extends BaseController<Product, ProductBackofficeModel, ProductCreationRequest, ProductUpdateRequest, ProductRepo, ProductMapper> {

    public ProductController(BaseService<Product, ProductBackofficeModel, ProductCreationRequest, ProductUpdateRequest, ProductRepo, ProductMapper> baseService) {
        super(baseService);
    }
}
