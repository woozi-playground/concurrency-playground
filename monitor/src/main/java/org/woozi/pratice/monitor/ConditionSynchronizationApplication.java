package org.woozi.pratice.monitor;

public class ConditionSynchronizationApplication {

    public static void main(String[] args) {
        final ConditionSynchronization conditionSynchronization = new ConditionSynchronization();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionSynchronization.produce();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionSynchronization.consume();
            }
        }).start();
    }
}
