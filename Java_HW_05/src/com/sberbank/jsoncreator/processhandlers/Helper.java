package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;

public interface Helper {
    void processHandlerWhileCyclingIterMain(StringBuilder result);
    void processHandlerBeforeFirstIterMain(StringBuilder result);
    Integer processHandlerBefore(StringBuilder result, Field field, Integer tabulationLevel, Boolean isCurlyBraces, Boolean isMain);
    void processCycleHandler(StringBuilder result, Object obj, Integer tabulationLevel, Boolean isCurlyBraces);
    Integer processHandlerAfter(StringBuilder result, Integer tabulationLevel, Boolean isCurlyBraces, Boolean isMain);
    String primitiveTypeProcessHandler(StringBuilder result, Field field, Object object, Integer tabulationLevel);
}
