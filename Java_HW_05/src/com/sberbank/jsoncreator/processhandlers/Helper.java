package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public interface Helper {
    Integer processHandlerBefore(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap);
    void processCycleHandler(StringBuilder result, Object obj, Integer tabulationLevel, Boolean isCurlyBraces);
    Integer processHandlerAfter(StringBuilder result, Field field, Integer tabulationLevel, Boolean isMap);
    String primitiveTypeProcessHandler(StringBuilder result, Field field, Object object, Integer tabulationLevel);
}
