package org.woozi.pratice.mutex;

public class Mutex {

    private boolean lock = false;

    public synchronized void acquire() {
        while(lock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.lock = true;
    }


    public synchronized void release() {
        lock = false;
        notify();
    }
}
