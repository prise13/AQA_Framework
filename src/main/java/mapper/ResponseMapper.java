package mapper;

import api_model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class ResponseMapper {

    public static CreateOrganizationResponse organizationResponseToObject(HttpResponse<String> response) {
        CreateOrganizationResponse createOrganizationResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createOrganizationResponse = objectMapper.readValue(response.body(), CreateOrganizationResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return createOrganizationResponse;
    }

    public static CreateBoardResponse boardResponseToObject(HttpResponse<String> response) {
        CreateBoardResponse createBoardResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createBoardResponse = objectMapper.readValue(response.body(), CreateBoardResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return createBoardResponse;
    }

    public static List<GetOrganizationBoardsResponse> organizationBoardsResponseToObject(HttpResponse<String> response) {
        List<GetOrganizationBoardsResponse> getOrganizationBoardsResponseList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            getOrganizationBoardsResponseList = objectMapper.readValue(response.body(), new TypeReference<List<GetOrganizationBoardsResponse>>(){});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return getOrganizationBoardsResponseList;
    }

    public static CreateListResponse listResponseToObject(HttpResponse<String> response) {
        CreateListResponse createListResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createListResponse = objectMapper.readValue(response.body(), CreateListResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return createListResponse;
    }

    public static List<GetBoardListsResponse> boardListsResponseToObject(HttpResponse<String> response) {
        List<GetBoardListsResponse> getBoardListsResponses = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            getBoardListsResponses = objectMapper.readValue(response.body(), new TypeReference<List<GetBoardListsResponse>>(){});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return getBoardListsResponses;
    }

    public static List<GetListCardsResponse> listCardsResponseToObject(HttpResponse<String> response) {
        List<GetListCardsResponse> getListCardsResponses = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            getListCardsResponses = objectMapper.readValue(response.body(), new TypeReference<List<GetListCardsResponse>>(){});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return getListCardsResponses;
    }

    public static UpdateCardResponse updateCardResponseToObject(HttpResponse<String> response) {
        UpdateCardResponse updateCardResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            updateCardResponse = objectMapper.readValue(response.body(), UpdateCardResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return updateCardResponse;
    }

}
