package com.freelance.skc.application.common;

import java.util.UUID;

public class IdGenerator {

    public static String generate(String modulePrefix){
        return modulePrefix.substring(0, 3) + "-" + UUID.randomUUID();

    }

}
