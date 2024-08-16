package org.woozi.pratice.semaphore.api;


import java.util.concurrent.Semaphore;

public class SharedDataApi {
    private int sharedValue = 0;
    private final Semaphore semaphore;

    public SharedDataApi(final Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void sum() {
        try {
            semaphore.acquire();
            for (int i = 0; i < 1000000; i++) {
                sharedValue++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getSharedValue() {
        return sharedValue;
    }
}
