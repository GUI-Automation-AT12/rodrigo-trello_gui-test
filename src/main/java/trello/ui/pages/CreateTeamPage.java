package trello.ui.pages;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.entities.Team;
import java.util.Map;

public class CreateTeamPage extends InitialPage {

    @FindBy(css = "input[data-test-id=\'header-create-team-name-input\']")
    WebElement teamName;

    @FindBy(css = "div[data-test-id='header-create-team-type-input']")
    private WebElement dropDownTeamType;

    @FindBy(css = "textarea[id$='create-team-org-description']")
    private WebElement inputTeamDescription;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement btnContinue;

    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement btnThisLater;

    private String typeOfTeam = "//*[contains(text(),'%s')]";
    private Team team;

    public CreateTeamPage() {
        team =  new Team();
    }

    /**
     * Method to return the team.
     * @return team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Method to create a team which parameters of the user.
     * @param teamInformation
     */
    public void createTeam(final Map<String, String> teamInformation) {
        team.processInformation(teamInformation);
        WebDriverHelper.setElement(teamName, team.getName());
        WebDriverHelper.clickElement(dropDownTeamType);
        selectDropDownOptionByName(team.getTypeOfTeam());
        WebDriverHelper.setElement(inputTeamDescription, team.getDescription());
        WebDriverHelper.clickElement(btnContinue);
        WebDriverHelper.waitUntil(btnThisLater);
        WebDriverHelper.clickElement(btnThisLater);
    }

    /**
     * Selects an element from a html select tag.
     * @param optionName
     */
    public void selectDropDownOptionByName(final String optionName) {
        By dropDownTeam = By.xpath(String.format(typeOfTeam, optionName));
        WebDriverHelper.clickElement(dropDownTeam);
    }
}
