package api;

import api_model.CreateBoardResponse;
import client.TrelloHTTPClient;
import constants.Constants;
import mapper.ResponseMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateBoardTest {

    @DataProvider
    public Object[][] createBoardDP() {
        return new Object[][] {
                {Constants.ORGANIZATION_ID, "boardPupu223","commonDescription"}
        };
    }


    @Test(dataProvider = "createBoardDP")
    public void createBoardTest(String idOrganization, String name, String description) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        CreateBoardResponse actual = ResponseMapper.boardResponseToObject(client.createBoard(idOrganization, name, description));
        CreateBoardResponse expected = new CreateBoardResponse();
        expected.setName(name);
        expected.setDesc(description);
        expected.setClosed(false);
        expected.setIdOrganization(idOrganization);
        expected.setPinned(false);
        Assert.assertEquals(actual, expected);
    }
}
