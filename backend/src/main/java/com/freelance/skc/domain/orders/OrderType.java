package com.freelance.skc.domain.orders;

import org.springframework.core.annotation.Order;

import java.util.Arrays;

public enum OrderType {
    REGULAR("Regular"),
    SINGULAR("Singular");

    private final String name;

    OrderType(String name) {
        this.name = name;
    }

    public static String enumToString(OrderType orderType){
        return Arrays.stream(OrderType.values())
                .filter(type -> type == orderType)
                .map(type -> type.name)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("OrderType not found"));
    }

    public static OrderType stringToEnum(String name){
        return Arrays.stream(OrderType.values())
                .filter(type -> type.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("OrderType name not found"));
    }

}
