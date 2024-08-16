package org.woozi.pratice.semaphore.api;

import java.util.concurrent.Semaphore;

public class SemaphoreApiApplication {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        final SharedDataApi sharedDataApi = new SharedDataApi(semaphore);
        final Thread firstThread = new Thread(() -> sharedDataApi.sum());
        final Thread secondThread = new Thread(() -> sharedDataApi.sum());

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Shared value: " + sharedDataApi.getSharedValue());
    }

}
