package com.freelance.skc.application.commands;

public interface UpdateCommandV2<T> {

    T update(T t, String value);

}
