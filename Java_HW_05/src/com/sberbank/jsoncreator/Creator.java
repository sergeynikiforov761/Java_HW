package com.sberbank.jsoncreator;

public interface Creator {
    String createString(Object object, Integer tabulationLevel) throws IllegalAccessException;
    String create() throws IllegalAccessException;
}
