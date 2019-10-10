package com.sberbank;

import java.util.HashMap;
import java.util.Map;

public class CountMapRealization<K> implements CountMap<K> {

    private Map<K, Integer> map = new HashMap<>();

    @Override
    public void add(K key) {
        if (map.containsKey(key)) {
            map.replace(key, map.get(key), map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    @Override
    public void addAll(CountMap<? extends K> countMap) {
        for (K key : countMap.asMap().keySet()) {
            if (map.containsKey(key)) {
                map.replace(key, map.get(key), map.get(key) + countMap.asMap().get(key));
            } else {
                map.put(key, countMap.asMap().get(key));
            }
        }
    }

    @Override
    public int count(K key) {
        return map.get(key);
    }

    @Override
    public int remove(K key) {
        return map.remove(key);
    }

    @Override
    public void copyTo(Map<? super K, Integer> map) {
        map.clear();
        for (K key : this.map.keySet()) {
            map.put(key, count(key));
        }
    }

    public Map<K, Integer> asMap() {
        return map;
    }

    public int size() {
        return map.keySet().size();
    }
}
