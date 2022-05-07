package service;

import api_model.GetOrganizationBoardsResponse;
import client.TrelloHTTPClient;
import constants.Constants;
import mapper.ResponseMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class TrelloService {

    public static String getBoardIdByName(String idOrganization, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        List<GetOrganizationBoardsResponse> organizationBoards = ResponseMapper.organizationBoardsResponseToObject(client.getOrganizationBoards(idOrganization));
        for(GetOrganizationBoardsResponse board : organizationBoards) {
            if (board.getName().equals(name)) {
                return board.getId();
            }
        }
        return null;
    }

}
