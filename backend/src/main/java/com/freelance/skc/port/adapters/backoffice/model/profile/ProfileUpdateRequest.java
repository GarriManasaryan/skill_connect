package com.freelance.skc.port.adapters.backoffice.model.profile;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public record ProfileUpdateRequest(
        @Nullable String title,
        @Nullable String description,
        @Nullable String userId
) {
    public Map<String, String> notNullValues(){
        Map<String, String> map = new HashMap<>();
        putNonEmptyValue(map, "description", this.description);
        putNonEmptyValue(map, "title", this.description);
        putNonEmptyValue(map, "userId", this.description);

        return map;
    }

    private static void putNonEmptyValue(Map<String, String> map, String key, String value){
        if (value != null){
            map.put(key, value);
        }
    }

}
