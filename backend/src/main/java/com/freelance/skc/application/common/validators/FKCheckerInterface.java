package com.freelance.skc.application.common.validators;

import java.util.List;

public interface FKCheckerInterface<R extends DomainRepoInterface<? extends DomainInterface>> {
    default void validate(R repoInt, String foreignIdToCheck, String customMessage){
        var availableFreelanceServiceIds = all(repoInt);
        if (foreignIdToCheck != null && !availableFreelanceServiceIds.contains(foreignIdToCheck)) {
            throw new IllegalStateException("ForeignKeyException: " + customMessage);
        }
    }

    default void validate(String foreignIdToCheck, String customMessage, List<String> allIds){
        if (foreignIdToCheck != null && !allIds.contains(foreignIdToCheck)) {
            throw new IllegalStateException("ForeignKeyException: " + customMessage);
        }
    }

    default void validateAll(R repoInt, List<String> foreignIdsToCheck, String customMessage){
        var allIds = all(repoInt);
        foreignIdsToCheck.forEach(id -> validate(id, customMessage, allIds));
    }

    default List<String> all(R repoInt){
        return repoInt.all().stream().map(DomainInterface::id).toList();
    }

}
