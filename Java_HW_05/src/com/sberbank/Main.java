package com.sberbank;

import com.sberbank.jsoncreator.XmlCreator;
import com.sberbank.jsoncreator.example.Address;
import com.sberbank.jsoncreator.JsonCreator;
import com.sberbank.jsoncreator.example.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
	// write your code here
        Address address = new Address("Moscow", "428019");
        char[] grades = {'1', '2', '3', '4', '5', '6'};
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        Map<String, Integer> map = new HashMap<>();
        map.put("cat", 1);
        map.put("dog", 2);
        map.put("kitty", 3);
        map.put("puppy", 4);
        Person person = new Person("Ilya", 18, address, grades, collection, map);//, address);
        System.out.println(new XmlCreator(person).create());
        System.out.println(new JsonCreator(person).create());
    }
}
