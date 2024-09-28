package com.freelance.skc.application.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.FeatureNumericMapper;
import com.freelance.skc.application.mappers.product.ProductMapper;
import com.freelance.skc.domain.product.Product;
import com.freelance.skc.domain.product.ProductRepo;
import com.freelance.skc.domain.product.feature.FeatureNumeric;
import com.freelance.skc.domain.product.feature.FeatureNumericRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.product.ProductUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeatureNumericService extends BaseService<FeatureNumeric, FeatureNumericBackofficeModel, FeatureNumericCreationRequest, FeatureNumericUpdateRequest, FeatureNumericRepo, FeatureNumericMapper> {

    public FeatureNumericService(FeatureNumericRepo repo, FeatureNumericMapper mapper) {
        super(repo, mapper);
    }
}
