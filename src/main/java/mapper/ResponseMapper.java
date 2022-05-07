package mapper;

import api_model.CreateBoardResponse;
import api_model.CreateListResponse;
import api_model.CreateOrganizationResponse;
import api_model.GetOrganizationBoardsResponse;
import com.fasterxml.jackson.core.type.TypeReference;
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

}
