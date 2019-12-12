package com.sberbank.jsoncreator.fieldprocessor;

import com.sberbank.jsoncreator.processhandlers.*;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class FieldClassifier {

    private Field field;
    private Object object;
    private Integer tabulationLevel;

    public FieldClassifier(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
    }

    public ProcessHandler classify() throws IllegalAccessException {
        field.setAccessible(true);
        if (new SimpleClasses().getSimpleClasses().contains(field.getType())) {
            return new PrimitiveTypeProcessHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof Collection) {
            return new CollectionProcessHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof Map) {
            return new MapProcessHandler(field, object, tabulationLevel);
        } else if ((field.get(object).getClass().equals(Object[].class)) ||
                (field.get(object).getClass().equals(int[].class)) ||
                (field.get(object).getClass().equals(char[].class)) ||
                (field.get(object).getClass().equals(byte[].class)) ||
                (field.get(object).getClass().equals(short[].class)) ||
                (field.get(object).getClass().equals(boolean[].class)) ||
                (field.get(object).getClass().equals(double[].class)) ||
                (field.get(object).getClass().equals(float[].class)) ||
                (field.get(object).getClass().equals(long[].class))) {
            return new ArrayProcessHandler(field, object, tabulationLevel);
        } else {
            return null;
        }
    }
}
