package com.sberbank;

public class Main {
    public static void main(String[] args) {
        //
        Task<Integer> task = new Task<>(() -> {
            int result = 0;
            int x = 1000000;
            int y = 20;
            for (int i = 0; i < x; i++) {
                result += y;
            }
            return result;
        });
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println(task.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
