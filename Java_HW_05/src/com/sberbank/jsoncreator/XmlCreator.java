package com.sberbank.jsoncreator;

import com.sberbank.jsoncreator.fieldprocessor.FieldClassifier;
import com.sberbank.jsoncreator.processhandlers.Helper;
import com.sberbank.jsoncreator.processhandlers.ProcessHandler;
import com.sberbank.jsoncreator.processhandlers.XMLStringGeneratorHelper;

import java.lang.reflect.Field;

public class XmlCreator implements Creator {
    private Object object;
    private StringBuilder result;
    private Helper helper;

    public XmlCreator(Object object) {
        this.object = object;
        this.result = new StringBuilder();
    }

    @Override
    public String create() throws IllegalAccessException {
        Integer tabulationLevel = 0;
        return createString(object, tabulationLevel);
    }

    @Override
    public String createString(Object object, Integer tabulationLevel) throws IllegalAccessException {
        helper = new XMLStringGeneratorHelper();
        result.append("\t".repeat(Math.max(0, tabulationLevel))).append("<").append(object.getClass().getSimpleName()).append(">\n");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            ProcessHandler fieldClassifier = new FieldClassifier(field, object, tabulationLevel, helper).classify();
            if (fieldClassifier != null) {
                result.append(fieldClassifier.generateString());
                result.append("\n");
            } else {
                createString(field.get(object), tabulationLevel + 1);
            }
        }
        result.append("\t".repeat(Math.max(0, tabulationLevel)))
                .append("</")
                .append(object.getClass()
                        .getSimpleName())
                .append(">");
        return result.toString();
    }
}
