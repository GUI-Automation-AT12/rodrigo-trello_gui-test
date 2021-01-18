package trello.stepdefs.login;

import io.cucumber.java.en.Given;
import trello.context.Context;
import trello.ui.pages.AtlassianLogin;
import trello.ui.pages.Login;

public class LoginStepdefs {

    private Context context;

    public LoginStepdefs(Context context) {
        this.context = context;
    }

    @Given("I log in to Trello with valid User credentials")
    public void iLogInToTrelloWithValidUserCredentials() {
        Login login = new Login();
        AtlassianLogin atlassianLogin = new AtlassianLogin();
        atlassianLogin.setPassword();
        atlassianLogin.tryLogin();
    }
}
