package com.freelance.skc.domain.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

class UserTest {

    @Test
    void test(){

        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User(
                "",
                "",
                "FOPL",
                Role.USER,
                5,
                UserDiscriminator.CLIENT,
                "GMT+3"
        ));
        allUsers.add(new User(
                "",
                "",
                "FOPAAL",
                Role.USER,
                5,
                UserDiscriminator.CLIENT,
                "GMT+3"
        ));

        System.out.println(
                allUsers.stream()
                        .filter(user -> user.email().equals("FOPAAL"))
                        .map(User::email)
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("User not found"))
        );


        var today = OffsetDateTime.now(ZoneId.of("GMT+3"));
        System.out.println(today);
        assert "1".equals("1");
    }

}