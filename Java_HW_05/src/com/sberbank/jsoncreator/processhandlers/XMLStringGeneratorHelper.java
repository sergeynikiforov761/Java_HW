package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class XMLStringGeneratorHelper implements Helper {
    public XMLStringGeneratorHelper() {
    }

    @Override
    public Integer processHandlerBefore(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap) {
        tabulationLevel = getInteger(field, tabulationLevel);
        result.append(getRepeat(tabulationLevel));
        result.append("<")
                .append(field.getName()).append(">");
        return tabulationLevel;
    }

    private Integer getInteger(Field field, Integer tabulationLevel) {
        tabulationLevel = getTabulationLevel(field, tabulationLevel);
        return tabulationLevel;
    }

    @Override
    public void processCycleHandler(StringBuilder result, Object obj, Integer tabulationLevel, Boolean isMap) {
        tabulationLevel++;
        result.append("\n");
        result.append(getRepeat(tabulationLevel));
        result.append("<entry>\n");
        tabulationLevel++;
        if (!isMap) {
            result.append(getRepeat(tabulationLevel))
                    .append("<value>")
                    .append(obj)
                    .append("</value>\n");
        } else {
            result.append(getRepeat(tabulationLevel))
                    .append("<key>")
                    .append(((Map.Entry<?, ?>) obj)
                            .getKey())
                    .append("</key>\n");
            result.append(getRepeat(tabulationLevel))
                    .append("<value>")
                    .append(((Map.Entry<?, ?>) obj)
                            .getValue())
                    .append("</value>\n");
        }
        tabulationLevel--;
        result.append(getRepeat(tabulationLevel));
        result.append("</entry>");
    }

    private String getRepeat(Integer tabulationLevel) {
        return "\t".repeat(Math.max(0, tabulationLevel));
    }

    @Override
    public Integer processHandlerAfter(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap) {
        tabulationLevel = getInteger(field, tabulationLevel);
        result.append("\n");
        result.append(getRepeat(tabulationLevel));
        result.append("</")
                .append(field.getName()).append(">");
        return tabulationLevel;
    }

    @Override
    public String primitiveTypeProcessHandler(StringBuilder result, Field field, Object object, Integer tabulationLevel) {
        tabulationLevel = getTabulationLevel(field, tabulationLevel);
        try {
            result.append(getRepeat(tabulationLevel))
                    .append("<")
                    .append(field.getName())
                    .append(">")
                    .append(field.get(object))
                    .append("</")
                    .append(field.getName())
                    .append(">");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private Integer getTabulationLevel(Field field, Integer tabulationLevel) {
        field.setAccessible(true);
        tabulationLevel++;
        return tabulationLevel;
    }
}
