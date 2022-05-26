package api;

import api_model.CreateOrganizationResponse;
import client.TrelloHTTPClient;
import mapper.ResponseMapper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class CreateOrganizationTest {

    @DataProvider
    public Object[][] createOrganizationDP() {
        return new Object[][] {
                {"TestOrganization132","testorganizationlink2323", "descriptions"}
        };
    }

    // End to end flow

    @Test(dataProvider = "createOrganizationDP")
    public void createOrganizationTest(String organizationName, String linkName, String description) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        CreateOrganizationResponse actual = ResponseMapper.organizationResponseToObject(client.createOrganization(organizationName, linkName, description));
        CreateOrganizationResponse expected = new CreateOrganizationResponse();
        expected.setName(linkName);
        expected.setDisplayName(organizationName);
        expected.setUrl(String.format("https://trello.com/%s", linkName));
        expected.setDesc(description);
        Assert.assertEquals(actual, expected);
    }
}
