package trello.ui.components;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.entities.Team;
import trello.ui.pages.InitialPage;

import java.util.HashMap;
import java.util.Map;

public class EditTeamForm extends InitialPage {

    @FindBy( id = "displayName")
    WebElement name;

    @FindBy(id = "name")
    WebElement shortName;

    @FindBy(id = "website")
    WebElement website;

    @FindBy(id = "desc")
    WebElement description;

    @FindBy(css = "form[id='organization-detail-form'] button[type=\"submit\"]")
    WebElement submitButton;

    @FindBy(css = "form[id='organization-detail-form'] button[type=\"button\"]")
    WebElement cancelButton;

    @FindBy(xpath = "//input[@id='teamTypeSelect']/parent::div/parent::div/parent::div")
    WebElement dropdown;

    private String typeOfTeam = "//*[contains(text(),'%s')]";

    private Team team;

    public EditTeamForm() {
        team = new Team();
    }

    /**
     * set name.
     */
    private void setName(final String givenName){
        WebDriverHelper.setElement(name, givenName);
    }

    /**
     * set short name.
     */
    private void setShortName(final String shortName){
        WebDriverHelper.setElement(this.shortName, shortName);
    }

    /**
     * set website.
     */
    private void setWebsite(final String website){
        WebDriverHelper.setElement(this.website, (website!=null)?website:"");
    }

    /**
     * set description.
     */
    private void setDesc(final String description){
        WebDriverHelper.setElement(this.description, (description!=null)?description:"");
    }

    /**
     * This method returns the team.
     * @return team.
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * Selects an element from a html select tag.
     * @param optionName
     */
    public void selectDropDownOptionByName(final String optionName) {
        WebDriverHelper.clickElement(dropdown);
        By dropDownTeam = By.xpath(String.format(typeOfTeam, optionName));
        WebDriverHelper.clickElement(dropDownTeam);
    }

    public void editTeam(final Map<String, String> teamInformation) {
        team.processInformation(teamInformation);
        processInformation(team.getTeamAsMap());
        WebDriverHelper.clickElement(submitButton);
    }

    /**
     * Process user's information as a map.
     * @param teamInformation
     */
    public void processInformation(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(teamInformation);
        teamInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param teamInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(teamInformation.get("Name")));
        strategyMap.put("Type", () -> selectDropDownOptionByName(teamInformation.get("Type")));
        strategyMap.put("Description", () -> setDesc(teamInformation.get("Description")));
        strategyMap.put("Website", () -> setWebsite(teamInformation.get("Website")));
        strategyMap.put("Short Name", () -> setShortName(teamInformation.get("Short Name")));
        return strategyMap;
    }
}
