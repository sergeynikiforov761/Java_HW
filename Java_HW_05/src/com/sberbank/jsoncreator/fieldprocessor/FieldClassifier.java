package com.sberbank.jsoncreator.fieldprocessor;

import com.sberbank.jsoncreator.processhandlers.*;
import com.sberbank.jsoncreator.processhandlers.simplearrayprocessorhandlers.*;

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
        } else if (field.get(object) instanceof Object[]) {
            return new ArrayProcessHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof int[]) {
            return new IntArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof char[]) {
            return new CharArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof byte[]) {
            return new ByteArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof short[]) {
            return new ShortArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof boolean[]) {
            return new BooleanArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof double[]) {
            return new DoubleArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof float[]) {
            return new FloatArrayProcessorHandler(field, object, tabulationLevel);
        } else if (field.get(object) instanceof long[]) {
            return new LongArrayProcessorHandler(field, object, tabulationLevel);
        } else {
            return null;
        }
    }
}
