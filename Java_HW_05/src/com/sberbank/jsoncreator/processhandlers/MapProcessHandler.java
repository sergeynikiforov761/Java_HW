package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class MapProcessHandler implements ProcessHandler {
    private Field field;
    private Object object;
    private Integer tabulationLevel;

    public MapProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        String result = "";
        int counter = 0;
        field.setAccessible(true);
        Map<?, ?> map = (Map<?, ?>) field.get(object);
        for (int j = 0; j < tabulationLevel; j++) {
            result += "\t";
        }
        result += "\"" + field.getName() + "\"" + ": ";
        result += "{";
        tabulationLevel++;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            counter++;
            result += "\n";
            for (int j = 0; j < tabulationLevel; j++) {
                result += "\t";
            }
            result += "\"" + entry.getKey() + "\"" + ": " + "\"" + entry.getValue() + "\"";
            if (counter != map.size()) {
                result += ",";
            }
        }
        result += "\n";
        tabulationLevel--;
        for (int j = 0; j < tabulationLevel; j++) {
            result += "\t";
        }
        result += "}    ";
        return result;
    }
}
