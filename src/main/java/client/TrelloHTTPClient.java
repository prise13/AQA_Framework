package client;

import constants.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TrelloHTTPClient {
    private final String API_KEY;
    private final String API_TOKEN;

    public TrelloHTTPClient() {
        this.API_KEY = Constants.API_KEY;
        this.API_TOKEN = Constants.API_TOKEN;
    }

    public HttpResponse<String> createOrganization(String organizationName) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "displayName": "%s",
                    "key": "%s",
                    "token": "%s"
                }""", organizationName, API_KEY, API_TOKEN);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
