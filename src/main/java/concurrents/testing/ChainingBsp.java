package concurrents.testing;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.spec.ECField;
import java.util.concurrent.CompletableFuture;

public class ChainingBsp {

    static void synchronous() {
        try (HttpClient client = HttpClient.newBuilder().build()) {
            HttpResponse<String> response = client.send(
                    createRequest("https://www.google.de"),
                    HttpResponse.BodyHandlers.ofString()
            );
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpRequest createRequest(String uri) {
        return HttpRequest.newBuilder().uri(URI.create(uri)).build();
    }

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Task 1");
                    return "Hello";
                }).thenApply(previousResult -> {
                    System.out.println("Task 2");
                    return previousResult + "World";
                }).thenApply(previousResult -> {
                    System.out.println("Task 3");
                    return previousResult + "!";
                }).exceptionally(ex -> {
                    System.err.println(ex.getMessage());
                    return null;
                });

        System.out.println("Join ...");
        var result = future.join();
        System.out.println(result);
        System.out.println("End");
    }
}
