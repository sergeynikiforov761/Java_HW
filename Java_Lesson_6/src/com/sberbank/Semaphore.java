package com.sberbank;

public class Semaphore {

    private final int maxTreadCount;
    private int currentThreadCount;

    public Semaphore(int maxTreadCount) {
        this.maxTreadCount = maxTreadCount;
        currentThreadCount = 0;
    }

    public void lock() {
        synchronized (this) {
            while (currentThreadCount >= maxTreadCount) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentThreadCount++;
        }
    }

    public void unlock() {
        synchronized (this) {
            currentThreadCount--;
            this.notify();
        }
    }
}
