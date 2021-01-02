import io.cucumber.java.en.Given;
import todoly.context.Context;
import todoly.ui.pages.AtlassianLogin;
import todoly.ui.pages.BaseLogin;

public class LoginStepdefs {

    private Context context;

    public LoginStepdefs(Context context) {
        this.context = context;
    }

    @Given("I am logged with valid credentials")
    public void iAmLoggedWithValidCredentials() {
        BaseLogin baseLogin = new BaseLogin();
        AtlassianLogin atLogin = new AtlassianLogin();
    }
}
