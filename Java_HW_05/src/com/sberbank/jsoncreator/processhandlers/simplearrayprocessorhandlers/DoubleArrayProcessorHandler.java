package com.sberbank.jsoncreator.processhandlers.simplearrayprocessorhandlers;

import com.sberbank.jsoncreator.processhandlers.ProcessHandler;

import java.lang.reflect.Field;

public class DoubleArrayProcessorHandler implements ProcessHandler {
    private Field field;
    private Object object;
    private Integer tabulationLevel;

    public DoubleArrayProcessorHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        String result = "";
        field.setAccessible(true);
        for (int i = 0; i < tabulationLevel; i++) {
            result += "\t";
        }
        tabulationLevel++;
        double[] array = (double[]) field.get(object);
        result += "\"" + field.getName() + "\"" + ": ";
        result += "[";
        for (int i = 0; i < array.length; i++) {
            result += "\n";
            for (int j = 0; j < tabulationLevel; j++) {
                result += "\t";
            }
            result += "\"" + array[i] + "\"";
            if (i != array.length - 1) {
                result += ",";
            }
        }
        result += "\n";
        tabulationLevel--;
        for (int i = 0; i < tabulationLevel; i++) {
            result += "\t";
        }
        result += "]";
        return result;
    }
}
