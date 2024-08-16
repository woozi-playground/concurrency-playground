package org.woozi.pratice.semaphore.counting;

import org.woozi.pratice.semaphore.Semaphore;

public class CountingSemaphore implements Semaphore {

    private int signal;
    private int permits;

    public CountingSemaphore(final int permits) {
        this.permits = permits;
        this.signal = permits;
    }

    @Override
    public synchronized void acquire() {
        try {
            while (this.signal == 0) wait();
            this.signal--;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void release() {
        this.signal++;
        this.notify();
    }
}
