package concurrents.uebungen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EuklidClass {

    public static void main(String[] args) {
        List<Integer> myIntList = List.of(1, 2, 3, 4, 5, 6);
        final int[] allValuesAddedSquared = {0};
        for (int i : myIntList) {
            allValuesAddedSquared[0] += (i * i);
        }
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            Future<Double> euclidianNormFuture = executor.submit(() -> {
                for (int i = 0; i < 20; i++) {
                    System.out.println(".");
                    Thread.sleep(100);
                }
                return Math.sqrt(allValuesAddedSquared[0]);
            });
            
            System.out.println(euclidianNormFuture.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
