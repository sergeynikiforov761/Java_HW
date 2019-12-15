package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public class PrimitiveTypeProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;
    private Helper helper;

    public PrimitiveTypeProcessHandler(Field field, Object object, Integer tabulationLevel, Helper helper) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
        this.helper = helper;
    }

    @Override
    public String generateString() {
        return helper.primitiveTypeProcessHandler(result, field, object, tabulationLevel);
    }
}
