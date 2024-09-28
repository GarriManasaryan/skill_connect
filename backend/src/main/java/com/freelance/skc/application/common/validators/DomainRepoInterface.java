package com.freelance.skc.application.common.validators;

import java.util.List;
import java.util.Optional;

public interface DomainRepoInterface<T extends DomainInterface> {

    List<T> all();

    void save(T domain);

    Optional<T> ofId(String id);

    void delete(String id);

    default void update(String id, T domain){
        delete(id);
        save(domain);
    }

}
