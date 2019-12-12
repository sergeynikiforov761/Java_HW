package com.sberbank.jsoncreator.fieldprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleClasses {

    private Class<?>[] simpleClasses = {String.class, Integer.class, Boolean.class, Byte.class, Short.class, Float.class, Double.class, Character.class, Number.class,
            byte.class, boolean.class, short.class, int.class, long.class, char.class, float.class, double.class};

    public SimpleClasses() {
    }

    public List<Class<?>> getSimpleClasses() {
        return new ArrayList<>(Arrays.asList(simpleClasses));

    }
}
