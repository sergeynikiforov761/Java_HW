package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class MapProcessHandler implements ProcessHandler {
    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;
    private Helper helper;

    public MapProcessHandler(Field field, Object object, Integer tabulationLevel, Helper helper) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
        this.helper = helper;
    }

    @Override
    public String generateString() throws IllegalAccessException {
        tabulationLevel = helper.processHandlerBefore(result, field, tabulationLevel, true);
        Map<?, ?> map = (Map<?, ?>) field.get(object);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            helper.processCycleHandler(result, entry, tabulationLevel, true);
        }
        tabulationLevel = helper.processHandlerAfter(result, field, tabulationLevel, true);
        return result.toString();
    }
}
