package org.woozi.pratice.semaphore;

public class SharedData {
    private int sharedValue = 0;
    private final Semaphore semaphore;

    public SharedData(final Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void sum() {
        semaphore.acquire();
        try {
            for(int i = 0; i < 1000000; i++) {
                sharedValue++;
            }
        } finally {
            semaphore.release();
        }
    }

    public int getSharedValue() {
        return sharedValue;
    }
}
