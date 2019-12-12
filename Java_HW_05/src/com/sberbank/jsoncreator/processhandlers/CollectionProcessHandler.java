package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Collection;

public class CollectionProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private Helper helper;
    private StringBuilder result;

    public CollectionProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
    }

    @Override
    public String generateString() throws IllegalAccessException {
        helper = new JsonStringGeneratorHelper();
        tabulationLevel = helper.processHandlerBefore(result, field, tabulationLevel, false, false);
        Collection<?> collection = (Collection<?>) field.get(object);
        for (Object obj : collection) {
            helper.processCycleHandler(result, obj, tabulationLevel, false);
        }
        tabulationLevel = helper.processHandlerAfter(result, tabulationLevel,false, false);
        return result.toString();
    }
}
