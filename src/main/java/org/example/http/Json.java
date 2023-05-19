package org.example.http;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Json {
    public static void main(String[] args) {
        try {
            // Tworzenie połączenia HTTP
            URL url = new URL("https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Sprawdzenie, czy odpowiedź serwera jest prawidłowa (kod 200)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Odczytanie danych z odpowiedzi serwera
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Deserializacja danych JSON za pomocą GSON
                Gson gson = new Gson();
                SuperheroesData superheroesData = gson.fromJson(response.toString(), SuperheroesData.class);

                // Wypisanie imion członków zespołu superbohaterów
                for (SuperheroMember member : superheroesData.getMembers()) {
                    System.out.println(member.getName());
                }
            } else {
                System.out.println("Błąd: " + responseCode);
            }

            // Zamknięcie połączenia HTTP
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperheroesData {
    private SuperheroMember[] members;

    public SuperheroMember[] getMembers() {
        return members;
    }
}

class SuperheroMember {
    private String name;

    public String getName() {
        return name;
    }
}


