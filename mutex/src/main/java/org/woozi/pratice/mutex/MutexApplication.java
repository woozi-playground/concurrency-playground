package org.woozi.pratice.mutex;

public class MutexApplication {

    public static void main(String[] args) throws InterruptedException {
        final SharedData sharedData = new SharedData(new Mutex());
        final Thread firstThread = new Thread(() -> sharedData.sum());
        final Thread secondThread = new Thread(() -> sharedData.sum());

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Shared value: " + sharedData.getSharedValue());
    }
}
