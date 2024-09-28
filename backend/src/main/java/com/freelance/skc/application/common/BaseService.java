package com.freelance.skc.application.common;

import com.freelance.skc.application.common.validators.DomainInterface;
import com.freelance.skc.application.common.validators.DomainRepoInterface;
import com.freelance.skc.application.mappers.interfaces.DomainMapper;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseBackofficeModel;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseCreationRequest;
import com.freelance.skc.port.adapters.backoffice.model.common.BaseUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public class BaseService<
        D extends DomainInterface,
        B extends BaseBackofficeModel,
        C extends BaseCreationRequest,
        U extends BaseUpdateRequest,
        R extends DomainRepoInterface<D>,
        M extends DomainMapper<D, B, C, U>
    > {

    private final R repo;
    private final M mapper;

    public BaseService(R repo, M mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public void save(@NotNull C creationRequest) {
        // как мы с Сашей обсуждали, по-хорошему надо FK проверку вставлять и на уровень постгри, а тут
        // но это перебор, уровня базы достаточно (ибо констрейнты есть)
        // но если прямо совсем хочется - тут будет базовый класс, который всешда можно override сделать на уровне ниже со всеми кастомными проверками (ибо всегда разные поля и тп)

        // как? в конкретном классе делаем override и выбираем save - там уже будет super.save(creationRequest) - до него свою логику, а super вызовет метод base;

        repo.save(mapper.of(creationRequest));
    }

    public void delete(@NotNull String id) {
        repo.delete(id);
    }

    public List<B> all() {
        return repo.all().stream().map(mapper::mapToBackofficeModel).toList();
    }

    public Optional<B> ofId(String id) {
        return repo.ofId(id).map(mapper::mapToBackofficeModel);
    }

    public void update(String id, @NotNull U updateRequest) {
        repo.ofId(id).ifPresentOrElse(
                (domain) -> {
                    var updatedDomain = mapper.newDomain(id, updateRequest);
                    repo.update(id, updatedDomain);
                },
                () -> {
                    throw new IllegalStateException("Entity not found");
                });
    }

    public R getRepo(){
        return repo;
    }

    public M getMapper(){
        return mapper;
    }

}
