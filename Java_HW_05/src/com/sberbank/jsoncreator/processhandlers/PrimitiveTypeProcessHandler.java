package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public class PrimitiveTypeProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;

    public PrimitiveTypeProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        field.setAccessible(true);
        String result = "";
        for (int i = 0; i < tabulationLevel; i++) {
            result += "\t";
        }
        result += "\"" + field.getName() + "\"" + ": " + "\"" + field.get(object) + "\"";
        return result;
    }
}
