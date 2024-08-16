package org.woozi.pratice.mutex;

public class SharedData {
    private int sharedValue = 0;
    private final Mutex mutex;

    public SharedData(final Mutex mutex) {
        this.mutex = mutex;
    }

    public void sum() {
        mutex.acquire();
        for(int i = 0; i < 1000000; i++) {
            sharedValue++;
        }
        mutex.release();
    }

    public int getSharedValue() {
        return sharedValue;
    }
}
