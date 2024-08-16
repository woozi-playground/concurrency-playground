package org.woozi.pratice.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        System.out.println("Trying to acquire lock..." + Thread.currentThread().getName());
        while (!lock.compareAndSet(false, true)) {
            System.out.println("Waiting for lock..." + Thread.currentThread().getName());
        }
        System.out.println("Lock acquired..." + Thread.currentThread().getName());
    }

    public void unlock() {
        lock.set(false);
    }
}
