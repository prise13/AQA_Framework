package api;

import client.TrelloHTTPClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateOrganizationTest {

    @Test
    public void createOrganizationTest() throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        Assert.assertEquals(client.createOrganization("TestOrganization").statusCode(), 200);
    }
}
