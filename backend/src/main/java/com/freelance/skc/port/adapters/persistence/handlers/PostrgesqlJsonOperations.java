package com.freelance.skc.port.adapters.persistence.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class PostrgesqlJsonOperations implements JsonOperations {
    private final ObjectMapper objectMapper;

    public PostrgesqlJsonOperations() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
    }

    public List<String> deserializeFromStringToListJson(@Nullable String jsonString){
        try{
            return Arrays.stream(this.objectMapper.readValue(jsonString, String[].class)).toList();
        }
        catch (JsonProcessingException e){
            return new ArrayList<>();
        }
    }

    @Override
    public ObjectMapper getObjectMapper(){
        return this.objectMapper;
    }

    @Override
    public <T> T asEntityRowMapper(String jsonString, Class<T> clazz) {
        try {
            return this.objectMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e){
            throw new IllegalStateException("Object cant be mapped: " + e.getMessage());
        }

    }

    @Override
    public List<String> asEntityIdsRawMapper(String jsonString) {
        var entities = new ArrayList<>(Arrays.asList(asEntityRowMapper(jsonString, String[].class)));
        return entities.stream().filter(Objects::nonNull).toList();
    }

    @Nullable
    public List<Object> deserializeFromStringToListObjects(@Nullable String jsonString){
        try{
            return Arrays.stream(this.objectMapper.readValue(jsonString, Object[].class)).toList();
        }
        catch (JsonProcessingException e){
            return null;
        }
    }

    @Nullable
    public String serializeFromObjToStringJson(@Nullable Object o){
        Object valueToWrite = o == null ? new ArrayList<>() : o;
        try{
            return this.objectMapper.writeValueAsString(valueToWrite);
        }
        catch (JsonProcessingException e){
            return null;
        }

    }

}
