package com.freelance.skc.port.adapters.backoffice.resource.common;

import com.freelance.skc.application.common.BaseService;
import com.freelance.skc.application.common.validators.DomainInterface;
import com.freelance.skc.application.common.validators.DomainRepoInterface;
import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BaseController<
        D extends DomainInterface,
        B extends BaseBackofficeModel,
        C extends BaseCreationRequest,
        U extends BaseUpdateRequest,
        R extends DomainRepoInterface<D>,
        M extends DomainMapper<D, B, C, U>
        > {

    private final BaseService<D, B, C, U, R, M> baseService;

    public BaseController(BaseService<D, B, C, U, R, M> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public void save(@Valid @RequestBody @NotNull C creationRequest) {
        baseService.save(creationRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        baseService.delete(id);
    }

    @GetMapping
    public List<B> all() {
        return baseService.all();
    }

    @GetMapping("/{id}")
    public Optional<B> ofId(@PathVariable String id) {
        return baseService.ofId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @Valid @RequestBody @NotNull U updateRequest) {
        baseService.update(id, updateRequest);
    }


}
