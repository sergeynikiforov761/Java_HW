package com.sberbank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }


    // returns index if instance of List contains element, else returns -1
    public static <T> int indexOf(List<? super T> source, T o) { // FIXME
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }


    public static <T> List<T> limit(List<? extends T> source, int size) {
        return List.copyOf(source.subList(0, size));
    }


    public static <T> void add(List<? super T> source, T o) { // FIXME
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) { // FIXME
        for (int i = 0; i < c2.size(); i++) {
            if (removeFrom.contains(c2.get(i))) {
                removeFrom.remove(c2.get(i));
            }
        }
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) { // FIXME
        for (int i = 0; i < c2.size(); i++) {
            if (!c1.contains(c2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            if (c1.contains(c2.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).compareTo(min) >= 0) && (list.get(i).compareTo(max) <= 0)) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((comparator.compare(list.get(i), min) >= 0) && comparator.compare(list.get(i), max) <= 0) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }
}
