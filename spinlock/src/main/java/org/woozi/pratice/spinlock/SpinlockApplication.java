package org.woozi.pratice.spinlock;

public class SpinlockApplication {

    public static void main(String[] args) {
        final SpinLock spinLock = new SpinLock();

        Runnable task = () -> {
            spinLock.lock();
            System.out.println("Thread " + Thread.currentThread().getName() + " 가 락을 획득했습니다.");
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            } finally {
                System.out.println("Thread " + Thread.currentThread().getName() + " 가 락을 해제합니다.");
                spinLock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 가 락을 해제했습니다.");
            }
        };

        final Thread firstThread = new Thread(task);
        final Thread secondThread = new Thread(task);

        firstThread.start();
        secondThread.start();
    }
}
