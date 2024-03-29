package com.sberbank.jsoncreator;

import com.sberbank.jsoncreator.fieldprocessor.FieldClassifier;
import com.sberbank.jsoncreator.processhandlers.Helper;
import com.sberbank.jsoncreator.processhandlers.JsonStringGeneratorHelper;
import com.sberbank.jsoncreator.processhandlers.ProcessHandler;

import java.lang.reflect.Field;

public class JsonCreator implements Creator {

    private Object object;
    private StringBuilder result;
    private Helper helper;

    public JsonCreator(Object object) {
        this.object = object;
        this.result = new StringBuilder();
    }

    @Override
    public String create() throws IllegalAccessException {
        Integer tabulationLevel = 1;
        return createString(object, tabulationLevel);
    }

    @Override
    public String createString(Object object, Integer tabulationLevel) throws IllegalAccessException {
        helper = new JsonStringGeneratorHelper();
        result.append("{\n");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            ProcessHandler fieldClassifier = new FieldClassifier(field, object, tabulationLevel, helper).classify();
            if (fieldClassifier != null) {
                result.append(fieldClassifier.generateString());
            } else {
                field.setAccessible(true);
                result.append("\t".repeat(Math.max(0, tabulationLevel)));
                result.append("\"").append(field.getName()).append("\"").append(": ");
                result.append("{");
                tabulationLevel++;
                createString(field.get(object), tabulationLevel + 1);
            }
            result.append(",\n");
        }
        result.delete(result.length() - 2, result.length() - 1);
        tabulationLevel--;
        result.append("\t".repeat(Math.max(0, tabulationLevel)));
        result.append("}");
        return result.toString();
    }
}
