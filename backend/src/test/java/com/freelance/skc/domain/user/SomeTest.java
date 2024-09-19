package com.freelance.skc.domain.user;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class SomeTest {

    <T> void consume(Consumer<T> consumer, T t){
        consumer.accept(t);
    }

    @Test
    void test(){

        Consumer<Integer> intCons = (Integer i) -> {
            System.out.println("\n");
            System.out.println(i);
            System.out.println("\n");
        };
        intCons.accept(5);
        consume(intCons, 5);
//        Supplier
//        BiConsumer
//        Function
        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("John44", 4);
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());

        assert value == 5;

        assert true;
    }

}