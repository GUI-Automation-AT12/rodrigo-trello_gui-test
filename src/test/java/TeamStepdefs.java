import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trello.context.Context;
import trello.ui.PageTransporter;
import trello.ui.pages.HomePage;
import trello.ui.pages.Login;

public class TeamStepdefs {

    private Context context;

    public TeamStepdefs(Context context) {
        this.context = context;
    }


    @When("I navigate to my team account page")
    public void iNavigateToMyTeamAccountPage() {
        PageTransporter.navigateToPage("");
    }

    @And("I edit My Team information with the following information")
    public void iEditMyTeamInformationWithTheFollowingInformation() {
        
    }

    @Then("The team's name should be updated in My Team account section")
    public void theTeamSNameShouldBeUpdatedInMyTeamAccountSection() {
        
    }

    @And("The url should be updated in the browser")
    public void theUrlShouldBeUpdatedInTheBrowser() {

    }

    @When("I open the create team form")
    public void iOpenTheCreateTeamForm() {
        HomePage home = new HomePage();
        home.clickCreateTeam();
        WebDriverManager.getInstance().quitWebDriver();
    }
}
