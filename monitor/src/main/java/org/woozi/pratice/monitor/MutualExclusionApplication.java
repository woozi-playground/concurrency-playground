package org.woozi.pratice.monitor;

public class MutualExclusionApplication {

    public static void main(String[] args) throws InterruptedException {
        final MutualExclusion mutualExclusion = new MutualExclusion();

        final Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                mutualExclusion.increment();
            }
        });

        final Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                mutualExclusion.increment();
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(mutualExclusion.getSharedValue());
    }
}
