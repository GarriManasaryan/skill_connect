package com.freelance.skc.application.validation;

import com.freelance.skc.application.validators.DomainInterface;
import org.springframework.stereotype.Component;

@Component
public class FKCheckerV2 {

    public void validate(DomainRepoIntV2 repoIntV2, String foreignIdToCheck){
        var availableFreelanceServiceIds = repoIntV2.allIds();
        if (foreignIdToCheck != null && !availableFreelanceServiceIds.contains(foreignIdToCheck)) {
            throw new IllegalStateException("Foreign key not found");
        }
    }

}
