package org.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class Main {
    public static void main(String[] args) {

        String url = "https://httpbin.org/post";

        // wyslanie reqesta
        String dane = null;
        try {
            dane = wyslijRequst(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // obrabianie odpowiedzi
        obrobDane(dane);
    }

    private static String wyslijRequst(String url) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"natalia\"}"))
                .header("Content-Type","application/json")
                .build();

        var odpowiedz = client.send(request, ofString());
        if (odpowiedz.statusCode() != 200) {
            System.exit(1);
        }
        return odpowiedz.body();
    }

    private static void obrobDane(String dane) {
        System.out.println(dane);

    }
}