package service;

import api_model.GetBoardListsResponse;
import api_model.GetListCardsResponse;
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

    public static String getListIdByName(String idBoard, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        List<GetBoardListsResponse> boardLists = ResponseMapper.boardListsResponseToObject(client.getBoardLists(idBoard));
        for (GetBoardListsResponse list : boardLists) {
            if (list.getName().equals(name)) {
                return list.getId();
            }
        }
        return null;
    }

    public static String getCardIdByName(String idList, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        List<GetListCardsResponse> listCards = ResponseMapper.listCardsResponseToObject(client.getListCards(idList));
        for (GetListCardsResponse card : listCards) {
            if (card.getName().equals(name)) {
                return card.getId();
            }
        }
        return null;
    }
}
