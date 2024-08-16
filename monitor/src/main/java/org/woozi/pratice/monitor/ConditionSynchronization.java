package org.woozi.pratice.monitor;

public class ConditionSynchronization {

    private boolean isAvailable = false;

    public synchronized void produce() {
        while (isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producing..." + Thread.currentThread().getName());
        isAvailable = true;
        notify();
    }

    public synchronized void consume() {
        while (!isAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consuming..."+ Thread.currentThread().getName());
        isAvailable = false;
        notify();
    }
}
