package org.woozi.pratice.spinlock;

public class SpinlockApplication {

    public static void main(String[] args) {
        final SpinLock spinLock = new SpinLock();

        Runnable task = () -> {
            spinLock.lock();
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired the lock.");
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            } finally {
                System.out.println("Thread " + Thread.currentThread().getName() + " will release the lock.");
                spinLock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " released the lock.");
            }
        };

        final Thread firstThread = new Thread(task);
        final Thread secondThread = new Thread(task);

        firstThread.start();
        secondThread.start();
    }
}
