package api;

import api_model.CreateListResponse;
import client.TrelloHTTPClient;
import constants.Constants;
import mapper.ResponseMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TrelloService;

import java.io.IOException;
import java.net.URISyntaxException;


public class CreateBoardListTest {

    @DataProvider
    public Object[][] createBoardDP() throws InterruptedException, IOException, URISyntaxException {
        return new Object[][] {
                {TrelloService.getBoardIdByName(Constants.ORGANIZATION_ID, "PachichiPi"), "Pakapu"}
        };
    }

    @Test(dataProvider = "createBoardDP")
    public void createBoardListTest(String idBoard, String name) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        CreateListResponse actual = ResponseMapper.listResponseToObject(client.createBoardList(idBoard, name));
        CreateListResponse expected = new CreateListResponse();
        expected.setName(name);
        expected.setClosed(false);
        expected.setIdBoard(idBoard);
        Assert.assertEquals(actual,expected);
    }
}
