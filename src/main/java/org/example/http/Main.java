package org.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.time.Duration;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class Main {

    private static final int N = 5;
    private static final int INITIAL_DELAY_MS = 1000;
    private static final double BACKOFF_FACTOR = 2.0;


    public static void main(String[] args) {

        String url = "https://httpbin.org/delay/2";

        // wyslanie reqesta
        String dane = null;
        try {
            dane = wyslijRequestZBackoff(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // obrabianie odpowiedzi
        obrobDane(dane);
    }

    public static String wyslijRequestZBackoff(String url) throws InterruptedException, IOException {
        int retries = 0;
        long delay = INITIAL_DELAY_MS;

        HttpClient client = HttpClient.newHttpClient();

        while (retries < N) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .timeout(Duration.ofSeconds(delay))
                        .uri(new URI(url))
                        .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"natalia\"}"))
                        .header("Content-Type", "application/json")
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    return response.body();
                }
            } catch (HttpTimeoutException ignored) {} catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Exponential backoff
            Thread.sleep(delay);
            delay *= BACKOFF_FACTOR;
            retries++;
        }

        throw new IOException("Failed to send request after maximum retries.");
    }

    private static void obrobDane(String dane) {
        System.out.println(dane);

    }
}