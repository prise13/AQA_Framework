package api;

import api_model.UpdateCardResponse;
import client.TrelloHTTPClient;
import constants.Constants;
import mapper.ResponseMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TrelloService;

import java.io.IOException;
import java.net.URISyntaxException;

public class UpdateCardTest {

    @DataProvider
    public Object[][] updateCardDP() throws InterruptedException, IOException, URISyntaxException {
        String idBoard = TrelloService.getBoardIdByName(Constants.ORGANIZATION_ID, "PachichiPi");
        String idList = TrelloService.getListIdByName(idBoard, "To do");
        String idCard = TrelloService.getCardIdByName(idList, "Create Minecraft");
        return new Object[][] {
                {idCard, idBoard, idList, "Hoho barabara"}
        };
    }

    @Test(dataProvider = "updateCardDP")
    public void updateCardTest(String idCard, String idBoard, String idList, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        UpdateCardResponse actual = ResponseMapper.updateCardResponseToObject(client.updateCard(idCard, name));
        UpdateCardResponse expected = new UpdateCardResponse();
        expected.setId(idCard);
        expected.setClosed(false);
        expected.setIdBoard(idBoard);
        expected.setIdList(idList);
        expected.setName(name);
        Assert.assertEquals(actual,expected);
    }
}
