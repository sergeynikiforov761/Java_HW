package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Collection;

public class CollectionProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private Helper helper;
    private StringBuilder result;

    public CollectionProcessHandler(Field field, Object object, Integer tabulationLevel, Helper helper) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
        this.helper = helper;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        tabulationLevel = helper.processHandlerBefore(result, field, tabulationLevel, false);
        Collection<?> collection = (Collection<?>) field.get(object);
        for (Object obj : collection) {
            helper.processCycleHandler(result, obj, tabulationLevel, false);
        }
        tabulationLevel = helper.processHandlerAfter(result, field, tabulationLevel,false);
        return result.toString();
    }
}
