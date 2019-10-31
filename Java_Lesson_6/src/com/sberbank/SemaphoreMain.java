package com.sberbank;

public class SemaphoreMain {
    private final Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {
        SemaphoreMain main = new SemaphoreMain();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> main.run()).start();
        }
    }

    public void run() {
        semaphore.lock();
        try {
            doRun();
        } finally {
            semaphore.unlock();
        }
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
