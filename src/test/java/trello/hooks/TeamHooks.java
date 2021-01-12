package trello.hooks;

import core.selenium.WebDriverManager;
import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.IdGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import trello.api.RequestManager;
import trello.api.utils.Authentication;
import trello.context.Context;

import java.io.IOException;

public class TeamHooks {
    private Context context;
    public TeamHooks( Context context) {
        this.context = context;
    }

    /**
     * create team.
     */
    @Before(value = "@createTeam")
    public void createTeam() throws IOException {
        String endpoint = EnvironmentProperties.getInstance().getBaseUrl() + "1/organizations";
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        IdGenerator idGenerator =  new IdGenerator();
        Response response = RequestManager.post(endpoint, "{\"displayName\":\"" + idGenerator.getGeneratedId() + "\"}");
        context.saveData(response.asString());
    }

    /**
     * Deletes team.
     */
    @After(value = "@deleteTeam")
    public void deleteTeam() {
        String endpoint = EnvironmentProperties.getInstance().getBaseUrl() + "1/organizations/";
        if (context.getTeam().getId() != null) {
            endpoint += context.getTeam().getId();
        }
        else {
             endpoint += context.getValueData("id");
        }
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        RequestManager.delete(endpoint);
    }

    /**
     * Deletes team.
     */
    @After(value = "@quitBrowser")
    public void quitBrowser() {
        WebDriverManager.getInstance().quitWebDriver();
    }
}
