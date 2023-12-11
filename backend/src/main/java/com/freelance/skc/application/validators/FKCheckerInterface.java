package com.freelance.skc.application.validators;

public interface FKCheckerInterface<R extends DomainRepoInterface<? extends DomainInterface>> {
//public interface FKCheckerInterface<T extends DomainInterface, R extends DomainRepoInterface<T>> {
    default void validate(R repoInt, String foreignIdToCheck, String customMessage){
        if (customMessage==null){
            customMessage = "not found";
        }
        var availableFreelanceServiceIds = repoInt.all().stream().map(DomainInterface::id).toList();
        if (foreignIdToCheck != null && !availableFreelanceServiceIds.contains(foreignIdToCheck)) {
            throw new IllegalStateException("ForeignKeyException: " + customMessage);
        }
    }

}
