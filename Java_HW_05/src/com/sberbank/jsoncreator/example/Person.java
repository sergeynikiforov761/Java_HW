package com.sberbank.jsoncreator.example;

import java.util.Collection;
import java.util.Map;

public class Person {
    private String name;
    private Number age;
    private Address address;
    private char[] grades;
    private Collection<Integer> collection;
    private Map<String, Integer> map;

    public Person(String name, Integer age, Address address, char[] grades, Collection<Integer> collection, Map<String, Integer> map) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.grades = grades;
        this.collection = collection;
        this.map = map;
    }
}
