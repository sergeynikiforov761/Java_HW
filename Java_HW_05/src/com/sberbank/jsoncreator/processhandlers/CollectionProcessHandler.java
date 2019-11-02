package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Collection;

public class CollectionProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;

    public CollectionProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        String result = "";
        int counter = 0;
        field.setAccessible(true);
        Collection<?> collection = (Collection<?>) field.get(object);
        for (int j = 0; j < tabulationLevel; j++) {
            result += "\t";
        }
        result += "\"" + field.getName() + "\"" + ": ";
        result += "[";
        tabulationLevel++;
        for (Object obj : collection) {
            counter++;
            result += "\n";
            for (int j = 0; j < tabulationLevel; j++) {
                result += "\t";
            }
            result += "\"" + obj + "\"";
            if (counter != collection.size()) {
                result += ",";
            }
        }
        result += "\n";
        tabulationLevel--;
        for (int j = 0; j < tabulationLevel; j++) {
            result += "\t";
        }
        result += "]";
        return result;
    }
}
