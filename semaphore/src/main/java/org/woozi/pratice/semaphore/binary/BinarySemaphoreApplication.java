package org.woozi.pratice.semaphore.binary;

import org.woozi.pratice.semaphore.SharedData;

public class BinarySemaphoreApplication {

    public static void main(String[] args) throws InterruptedException {
        final BinarySemaphore binarySemaphore = new BinarySemaphore();
        final SharedData sharedData = new SharedData(binarySemaphore);
        final Thread firstThread = new Thread(() -> sharedData.sum());
        final Thread secondThread = new Thread(() -> sharedData.sum());

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Shared value: " + sharedData.getSharedValue());
    }
}
