package academy.learn.discrete.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws Exception {
        String url = "http://www.example.com";

        getURLSync(url);
        postURLSync(url);
        getURLAsync(url);
    }

    private static void getURLAsync(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        CompletableFuture<HttpResponse<String>> future = client.sendAsync(
                HttpRequest
                    .newBuilder(new URI(url))
                    .GET()
                    .build(),
                HttpResponse.BodyHandler.asString()
        );

        System.out.println("Request has been made...");

        while (!future.isDone())
            System.out.println("Working...");

        System.out.println("Request complete");
        processResponse(future.get());
    }

    public static void getURLSync(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder(new URI(url))
                .GET()
                .build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandler.asString());
        processResponse(response);
    }

    private static void processResponse(HttpResponse response) {
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());

        printHeaders(response);
    }

    private static void printHeaders(HttpResponse response) {
        System.out.println("Headers: ");
        HttpHeaders headers = response.headers();
        var map = headers.map();
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }


    public static void postURLSync(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse response = client.send(
                HttpRequest
                    .newBuilder(new URI(url))
                    .headers("Foo", "Foo-val", "bar", "Bar-val")
                    .POST(HttpRequest.BodyPublisher.fromString("This is the String"))
                    .build(),
                HttpResponse.BodyHandler.asFile(Paths.get("fileFreddyFishFinger.txt"))
        );

        processResponse(response);

    }
}
