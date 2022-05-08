package api;

import client.TrelloHTTPClient;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TrelloService;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateCardTest {

    @DataProvider
    public Object[][] createCardDP() throws InterruptedException, IOException, URISyntaxException {
        String idBoard = TrelloService.getBoardIdByName(Constants.ORGANIZATION_ID, "PachichiPi");
        return new Object[][] {
                {TrelloService.getListIdByName(idBoard, "Pakapu"), "Create new test case"}
        };
    }

    @Test(dataProvider = "createCardDP")
    public void createCardTest(String idList, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        Assert.assertEquals(client.createCard(idList, name).statusCode(), 200);
    }
}
