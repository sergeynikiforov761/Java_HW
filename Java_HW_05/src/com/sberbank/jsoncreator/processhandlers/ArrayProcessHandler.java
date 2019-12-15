package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ArrayProcessHandler implements ProcessHandler {
    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;
    private Helper helper;

    public ArrayProcessHandler(Field field, Object object, Integer tabulationLevel, Helper helper) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
        this.helper = helper;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        tabulationLevel = helper.processHandlerBefore(result, field, tabulationLevel, false);
        Object array = field.get(object);
        int i = 0;
        while (true) {
            try {
                helper.processCycleHandler(result, Array.get(array, i), tabulationLevel, false);
                i++;
            } catch (ArrayIndexOutOfBoundsException error) {
                break;
            }
        }
        tabulationLevel = helper.processHandlerAfter(result, field, tabulationLevel, false);
        return result.toString();
    }
}
