package com.freelance.skc.application.common.validators;

import org.springframework.stereotype.Component;

@Component
// здесь нужно два параметра, ибо 2 ? не тянет
public class FKChecker<T extends DomainRepoInterface<? extends DomainInterface>> implements FKCheckerInterface<T>{

}