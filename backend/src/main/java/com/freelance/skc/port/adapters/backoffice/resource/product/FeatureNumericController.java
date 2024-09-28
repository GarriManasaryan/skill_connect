package com.freelance.skc.port.adapters.backoffice.resource.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.FeatureNumericMapper;
import com.freelance.skc.domain.product.feature.FeatureNumeric;
import com.freelance.skc.domain.product.feature.FeatureNumericRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureNumericUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/feature-numerics")
public class FeatureNumericController extends BaseController<FeatureNumeric, FeatureNumericBackofficeModel, FeatureNumericCreationRequest, FeatureNumericUpdateRequest, FeatureNumericRepo, FeatureNumericMapper> {

    public FeatureNumericController(BaseService<FeatureNumeric, FeatureNumericBackofficeModel, FeatureNumericCreationRequest, FeatureNumericUpdateRequest, FeatureNumericRepo, FeatureNumericMapper> baseService) {
        super(baseService);
    }
}
