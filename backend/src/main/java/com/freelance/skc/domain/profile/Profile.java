package com.freelance.skc.domain.profile;

import com.freelance.skc.application.IdGenerator;
import com.freelance.skc.application.validators.DomainInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public record Profile(
        @NotNull String id,
        @NotNull String title,
        @NotNull String description,
        byte[] sellerPic,
        @NotNull String userId
) implements DomainInterface {
    public static Profile of(
            @NotNull String title,
            @NotNull String description,
            byte[] sellerPic,
            @NotNull String userId
    ) {
        return new Profile(
                IdGenerator.generate("prf"),
                title,
                description,
                sellerPic,
                userId
        );
    }

    public Supplier<String> acs (){
        return () -> this.description + "offset что-то там именно в момент вызова, поэтому не просто стринг";
    }
}
