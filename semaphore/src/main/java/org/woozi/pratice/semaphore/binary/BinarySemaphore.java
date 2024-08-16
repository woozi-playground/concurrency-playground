package org.woozi.pratice.semaphore.binary;

import org.woozi.pratice.semaphore.Semaphore;

public class BinarySemaphore implements Semaphore {

    private int signal = 1;

    @Override
    public synchronized void acquire() {
        try {
            while (this.signal == 0) wait();
            this.signal = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void release() {
        this.signal = 1;
        this.notify();
    }
}
