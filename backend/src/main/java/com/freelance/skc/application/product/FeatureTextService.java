package com.freelance.skc.application.product;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.mappers.product.FeatureTextMapper;
import com.freelance.skc.domain.product.feature.FeatureText;
import com.freelance.skc.domain.product.feature.FeatureTextRepo;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.product.feature.FeatureTextUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeatureTextService extends BaseService<FeatureText, FeatureTextBackofficeModel, FeatureTextCreationRequest, FeatureTextUpdateRequest, FeatureTextRepo, FeatureTextMapper> {

    public FeatureTextService(FeatureTextRepo repo, FeatureTextMapper mapper) {
        super(repo, mapper);
    }
}
