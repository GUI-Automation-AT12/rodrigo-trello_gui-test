import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import todoly.context.Context;
import todoly.ui.PageTransporter;

public class TeamStepdefs {

    private Context context;

    public TeamStepdefs(Context context) {
        this.context = context;
    }

    @Given("I log in to Trello with Editable User credentials")
    public void iLogInToTrelloWithEditableUserCredentials() {
        
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
}
