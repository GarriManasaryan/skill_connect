package com.freelance.skc.application.validators;

import java.util.List;

public interface DomainRepoInterface<T extends DomainInterface> {

    List<T> all();

}
