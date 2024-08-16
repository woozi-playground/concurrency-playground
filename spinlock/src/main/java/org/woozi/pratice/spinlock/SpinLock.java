package org.woozi.pratice.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        while (!lock.compareAndSet(false, true)) {
        }
    }

    public void unlock() {
        lock.set(false);
    }
}
