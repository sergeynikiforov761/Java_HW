package com.sberbank.jsoncreator;

import com.sberbank.jsoncreator.fieldprocessor.FieldClassifier;
import com.sberbank.jsoncreator.processhandlers.Decorator;
import com.sberbank.jsoncreator.processhandlers.Helper;
import com.sberbank.jsoncreator.processhandlers.JsonStringGeneratorHelper;
import com.sberbank.jsoncreator.processhandlers.ProcessHandler;

import java.lang.reflect.Field;

public class JsonCreator {

    private Object object;
    private StringBuilder result;
    private Helper helper;

    public JsonCreator(Object object) {
        this.object = object;
        this.result = new StringBuilder();
    }

    public String create() throws IllegalAccessException {
        Integer tabulationLevel = 1;
        return createJsonString(object, tabulationLevel);
    }

    public String createJsonString(Object object, Integer tabulationLevel) throws IllegalAccessException {
        helper = new JsonStringGeneratorHelper();
        helper.processHandlerBeforeFirstIterMain(result);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            ProcessHandler fieldClassifier = new FieldClassifier(field, object, tabulationLevel).classify();
            if (fieldClassifier != null) {
                result.append(new Decorator(fieldClassifier).generateString());
            } else {
                helper.processHandlerBefore(result, field, tabulationLevel, true, true);
                createJsonString(field.get(object), tabulationLevel + 1);
            }
            helper.processHandlerWhileCyclingIterMain(result);
        }
        helper.processHandlerAfter(result, tabulationLevel, true, true);
        return result.toString();
    }
}
