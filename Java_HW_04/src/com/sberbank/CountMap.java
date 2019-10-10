package com.sberbank;

import java.util.Map;

public interface CountMap<K> {
    void add(K key);

    void addAll(CountMap<? extends K> countMap);

    int count(K key);

    int remove(K key);

    //<key, count>
    Map<K, Integer> asMap();

    void copyTo(Map<? super K, Integer> map); //<key, count>

    int size();

}