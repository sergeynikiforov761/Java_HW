package com.sberbank;

public class Main {
    private final Semaphore semaphore = new Semaphore(4);
    private final Barier barier = new Barier(5);
    private int inc = 0;

    public static void main(String[] args) {
        Main main = new Main();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> main.runSemaphore()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> main.runBarier()).start();
        }
    }

    public void runSemaphore() {
        semaphore.lock();
        doRun();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.unlock();

    }

    public void runBarier() {
        doRun();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barier.await();
    }

    private  void doRun() {
        System.out.println("12345");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
