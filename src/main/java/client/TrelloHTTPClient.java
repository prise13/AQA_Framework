package client;

import constants.Constants;
import jdk.jfr.Frequency;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

    public HttpResponse<String> createOrganization(String organizationName, String linkName, String description) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "displayName": "%s",
                    "key": "%s",
                    "token": "%s",
                    "name":"%s",
                    "desc":"%s"
                }""", organizationName, API_KEY, API_TOKEN, linkName, description);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/organizations"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> createBoard(String idOrganization,String name, String desc) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "key":"%s",
                    "token":"%s",
                    "name":"%s",
                    "desc":"%s",
                    "idOrganization":"%s"
                }""", API_KEY, API_TOKEN, name, desc, idOrganization);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> createBoardList(String idBoard, String name) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "key":"%s",
                    "token":"%s",
                    "idBoard":"%s",
                    "name":"%s"
                }""", API_KEY, API_TOKEN, idBoard, name);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/lists"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getOrganizationBoards(String idOrganization) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://api.trello.com/1/organizations/%s/boards?key=%s&token=%s", idOrganization, API_KEY, API_TOKEN)))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getBoardLists(String idBoard) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://api.trello.com/1/boards/%s/lists?key=%s&token=%s", idBoard, API_KEY, API_TOKEN)))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> createCard(String idList, String name) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "key":"%s",
                    "token":"%s",
                    "idList":"%s",
                    "name":"%s"
                }""", API_KEY, API_TOKEN, idList, name);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/cards"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getListCards(String idList) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://api.trello.com/1/lists/%s/cards?key=%s&token=%s", idList, API_KEY, API_TOKEN)))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> updateCard(String idCard, String name) throws URISyntaxException, IOException, InterruptedException {
        String requestBody = String.format("""
                {
                    "key":"%s",
                    "token":"%s",
                    "name":"%s"
                }""", API_KEY, API_TOKEN, name);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://api.trello.com/1/cards/%s", idCard)))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
