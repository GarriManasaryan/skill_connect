package com.freelance.skc.port.adapters.persistence.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface JsonOperations {

    List<String> deserializeFromStringToListJson(@Nullable String jsonString);

    ObjectMapper getObjectMapper();

    <T> T asEntityRowMapper(String jsonString, Class<T> clazz);

    List<String> asEntityIdsRawMapper(String jsonString);

    @Nullable
    List<Object> deserializeFromStringToListObjects(@Nullable String jsonString);

    @Nullable
    String serializeFromObjToStringJson(@Nullable Object o);

}
