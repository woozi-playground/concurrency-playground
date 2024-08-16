package org.woozi.pratice.monitor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class MonitorApplication {

    public static void main(String[] args) {
        final SharedData sharedData = new SharedData();

        final List<CompletableFuture<Void>> list = IntStream.range(0, 10000)
                .mapToObj(it -> CompletableFuture.runAsync(() -> sharedData.increment()))
                .toList();
        CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)).join();
        System.out.println(sharedData.getSharedValue());
    }
}
