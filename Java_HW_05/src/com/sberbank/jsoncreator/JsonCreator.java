package com.sberbank.jsoncreator;

import com.sberbank.jsoncreator.fieldprocessor.FieldClassifier;
import com.sberbank.jsoncreator.processhandlers.Decorator;
import com.sberbank.jsoncreator.processhandlers.ProcessHandler;

import java.lang.reflect.Field;

public class JsonCreator {

    private Object object;

    public JsonCreator(Object object) {
        this.object = object;
    }

    public String create() throws IllegalAccessException {
        Integer tabulationLevel = 1;
        return createJsonString(object, tabulationLevel);
    }

    public String createJsonString(Object object, Integer tabulationLevel) throws IllegalAccessException {
        String jsonString = "{";
        jsonString += "\n";
        Field[] fields = object.getClass().getDeclaredFields();
        int counter = 0;
        for (Field field : fields) {
            counter++;
            ProcessHandler fieldClassifier = new FieldClassifier(field, object, tabulationLevel).classify();
            if (fieldClassifier != null) {
                jsonString += new Decorator(fieldClassifier).generateString();
                if (counter != fields.length) {
                    jsonString += ",";
                }
                jsonString += "\n";
            } else {
                for (int i = 0; i < tabulationLevel; i++) {
                    jsonString += "\t";
                }
                jsonString += "\"" + field.getName() + "\"" + ": ";
                jsonString += createJsonString(field.get(object), tabulationLevel + 1);
                if (counter != fields.length) {
                    jsonString += ",";
                }
                jsonString += "\n";
            }
        }
        tabulationLevel--;
        for (int i = 0; i < tabulationLevel; i++) {
            jsonString += "\t";
        }
        jsonString += "}";
        return jsonString;
    }
}
