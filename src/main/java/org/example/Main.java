package org.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String jsonInputString = "{\"userId\": 1,"
                    + "\"id\": 1,"
                    + "\"title\": \"delectus aut autem\","
                    + "\"completed\": false}";

            byte[] jsonBytes = jsonInputString.getBytes(StandardCharsets.UTF_8);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonBytes, 0, jsonBytes.length);
            }

            int responseCode = connection.getResponseCode();
            //Questao 10
            System.out.println("Código de resposta: " + responseCode);

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}