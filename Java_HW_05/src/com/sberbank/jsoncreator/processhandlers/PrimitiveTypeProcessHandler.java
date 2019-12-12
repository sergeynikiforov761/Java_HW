package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public class PrimitiveTypeProcessHandler implements ProcessHandler {

    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;
    private Helper helper;

    public PrimitiveTypeProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();    }

    @Override
    public String generateString() {
        helper = new JsonStringGeneratorHelper();
        return helper.primitiveTypeProcessHandler(result, field, object, tabulationLevel);
    }
}
