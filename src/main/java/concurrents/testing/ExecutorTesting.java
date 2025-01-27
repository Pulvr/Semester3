package concurrents.testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTesting {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            executorService.submit(() -> System.out.println("Task1"));
            executorService.submit(() -> System.out.println("Task2"));
            executorService.submit(() -> System.out.println("Task3"));
            executorService.submit(() -> System.out.println("Task4"));
        }
    }
}
