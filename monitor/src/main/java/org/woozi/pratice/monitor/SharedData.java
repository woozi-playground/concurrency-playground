package org.woozi.pratice.monitor;

public class SharedData {
    private int sharedValue = 0;

    public void increment() {
        synchronized (this) {
            this.sharedValue = sharedValue + 1;
        }
    }

    public void decrement() {
        this.sharedValue = sharedValue - 1;
    }

    public int getSharedValue() {
        return sharedValue;
    }
}
