package com.freelance.skc.application.validators;

public interface FKCheckerInterface<RepoInt extends DomainRepoInterface<DomainInterface>> {

    default void validate(RepoInt repoInt, String foreignIdToCheck){
        var availableFreelanceServiceIds = repoInt.all().stream().map(DomainInterface::id).toList();
        if (foreignIdToCheck != null && !availableFreelanceServiceIds.contains(foreignIdToCheck)) {
            throw new IllegalStateException("Foreign key not found");
        }
    }

}
