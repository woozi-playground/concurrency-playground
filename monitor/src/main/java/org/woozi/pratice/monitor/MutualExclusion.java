package org.woozi.pratice.monitor;

public class MutualExclusion {
    private int sharedValue = 0;

    public synchronized void increment() {
        this.sharedValue = sharedValue + 1;
    }

    public void decrement() {
        this.sharedValue = sharedValue - 1;
    }

    public int getSharedValue() {
        return sharedValue;
    }
}
