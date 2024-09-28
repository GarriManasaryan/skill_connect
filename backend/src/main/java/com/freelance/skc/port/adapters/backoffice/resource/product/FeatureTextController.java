package com.freelance.skc.port.adapters.backoffice.resource.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.FeatureTextMapper;
import com.freelance.skc.domain.product.feature.FeatureText;
import com.freelance.skc.domain.product.feature.FeatureTextRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextUpdateRequest;
import com.freelance.skc.port.adapters.backoffice.resource.common.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/feature-texts")
public class FeatureTextController extends BaseController<FeatureText, FeatureTextBackofficeModel, FeatureTextCreationRequest, FeatureTextUpdateRequest, FeatureTextRepo, FeatureTextMapper> {

    public FeatureTextController(BaseService<FeatureText, FeatureTextBackofficeModel, FeatureTextCreationRequest, FeatureTextUpdateRequest, FeatureTextRepo, FeatureTextMapper> baseService) {
        super(baseService);
    }
}
