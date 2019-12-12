package com.sberbank.jsoncreator.processhandlers;

import java.lang.reflect.Field;
import java.util.Map;

public class MapProcessHandler implements ProcessHandler {
    private Field field;
    private Object object;
    private Integer tabulationLevel;
    private StringBuilder result;
    private Helper helper;

    public MapProcessHandler(Field field, Object object, Integer tabulationLevel) {
        this.field = field;
        this.object = object;
        this.tabulationLevel = tabulationLevel;
        this.result = new StringBuilder();
    }

    @Override
    public String generateString() throws IllegalAccessException {
        helper = new JsonStringGeneratorHelper();
        tabulationLevel = helper.processHandlerBefore(result, field, tabulationLevel, true, false);
        Map<?, ?> map = (Map<?, ?>) field.get(object);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            helper.processCycleHandler(result, entry, tabulationLevel, true);
        }
        tabulationLevel = helper.processHandlerAfter(result, tabulationLevel, true, false);
        return result.toString();
    }
}
