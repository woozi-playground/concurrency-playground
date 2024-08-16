package org.woozi.pratice.semaphore.counting;

import org.woozi.pratice.semaphore.SharedData;

public class SemaphoreApplication {

    public static void main(String[] args) throws InterruptedException {
        final CountingSemaphore countingSemaphore = new CountingSemaphore(10);
        final SharedData sharedData = new SharedData(countingSemaphore);
        final Thread firstThread = new Thread(() -> sharedData.sum());
        final Thread secondThread = new Thread(() -> sharedData.sum());

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Shared value: " + sharedData.getSharedValue());
    }

}
