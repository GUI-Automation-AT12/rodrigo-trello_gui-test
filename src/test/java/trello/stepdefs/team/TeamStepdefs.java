package trello.stepdefs.team;

import core.selenium.WebDriverManager;
import core.selenium.utils.IdGenerator;
import core.selenium.utils.Mapper;
import core.selenium.utils.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import trello.context.Context;
import trello.ui.PageTransporter;
import trello.ui.StringUtils;
import trello.ui.pages.CreateTeamPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.TeamDetailsPage;

import java.util.Map;

public class TeamStepdefs {

    private Context context;

    public TeamStepdefs(Context context) {
        this.context = context;
    }


    @When("I navigate to my team account page")
    public void iNavigateToMyTeamAccountPage() {
        HomePage home =  new HomePage();
        PageTransporter.navigateToAccount(context.getValueData("name"));
    }

    @And("I edit My Team information with the following information")
    public void iEditMyTeamInformationWithTheFollowingInformation(Map<String, String> storedInformation) {
        storedInformation = Mapper.replaceId(storedInformation);
        TeamDetailsPage team =  new TeamDetailsPage();
        team.clickEditTeam();
        team.getEditForm().editTeam(storedInformation);
        context.setTeam(team.getEditForm().getTeam());
    }

    @Then("The team's name should be updated in My Team account section")
    public void theTeamSNameShouldBeUpdatedInMyTeamAccountSection() {
        TeamDetailsPage teamDetails = new TeamDetailsPage();
        teamDetails.findTeamName(context.getTeam().getName());
        Assert.assertEquals(teamDetails.getTeamName(), context.getTeam().getName());
    }

    @And("The url should be updated in the browser")
    public void theUrlShouldBeUpdatedInTheBrowser() {
        Assert.assertEquals(StringUtils.getUrlId(PageTransporter.getActualUrl()), context.getTeam().getShortName());
    }

    @When("I open the create team form")
    public void iOpenTheCreateTeamForm() {
        HomePage home = new HomePage();
        home.clickCreateTeam();
    }

    @And("I put the following information on create team section")
    public void iPutTheFollowingInformationOnCreateTeamSection(Map<String, String> teamInformation) {
        teamInformation = Mapper.replaceId(teamInformation);
        CreateTeamPage team = new CreateTeamPage();
        team.createTeam(teamInformation);
        context.setTeam(team.getTeam());
    }

    @Then("the team's information should match")
    public void theTeamSInformationShouldMatch() {
        TeamDetailsPage teamDetailsPage = new TeamDetailsPage();
        context.getTeam().setId(StringUtils.getUrlId(PageTransporter.getActualUrl()));
        teamDetailsPage.findTeamName(context.getTeam().getName());
        teamDetailsPage.findTeamDescription(context.getTeam().getDescription());
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(teamDetailsPage.getTeamName(), context.getTeam().getName());
        softAssertion.assertEquals(teamDetailsPage.getTeamDescription(), context.getTeam().getDescription());
        softAssertion.assertAll();
        PageTransporter.navigateToPage("home");
    }

}
