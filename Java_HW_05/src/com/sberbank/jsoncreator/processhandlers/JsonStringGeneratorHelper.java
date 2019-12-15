package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class JsonStringGeneratorHelper implements Helper {
    public JsonStringGeneratorHelper() {
    }

    @Override
    public Integer processHandlerBefore(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap) {
        field.setAccessible(true);
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        result.append("\"").append(field.getName()).append("\"").append(": ");
        if (!isMap) {
            result.append("[");
        } else {
            result.append("{");
        }
        tabulationLevel++;
        return tabulationLevel;
    }

    @Override
    public void processCycleHandler(StringBuilder result, Object obj, Integer tabulationLevel, Boolean isMap) {
        result.append("\n");
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        if (!isMap) {
            result.append("\"").append(obj).append("\"");
        } else {
            result.append("\"").append(((Map.Entry<?, ?>) obj).getKey()).append("\"").append(": ").append("\"")
                    .append(((Map.Entry<?, ?>) obj).getValue()).append("\"");
        }
        result.append(",");
    }

    @Override
    public Integer processHandlerAfter(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap) {
        result.delete(result.length() - 1, result.length());
        tabulationLevel--;
        result.append("\n");
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        if (!isMap) {
            result.append("]");
        } else {
            result.append("}");
        }
        return tabulationLevel;
    }

    @Override
    public String primitiveTypeProcessHandler(StringBuilder result, Field field, Object object, Integer tabulationLevel) {
        field.setAccessible(true);
        try {
            result.append("\t".repeat(Math.max(0, tabulationLevel))).append("\"").append(field.getName()).append("\": \"").append(field.get(object)).append("\"");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
