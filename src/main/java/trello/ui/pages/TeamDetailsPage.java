package trello.ui.pages;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.ui.components.EditTeamForm;

public class TeamDetailsPage extends InitialPage{

    @FindBy(css = "div[class=\"js-current-details\"] .js-react-root button")
    WebElement editButton;
    private EditTeamForm editTeamForm;
    private WebElement teamName;
    private WebElement teamDescription;
    private String teamNamePath = "//h1[contains(text(),'%s')]";
    private String teamDescriptionPath = "//*[contains(text(),'%s')]";

    /**
     * Team details page constructor.
     */
    public TeamDetailsPage() {
        editTeamForm = new EditTeamForm();
        WebDriverHelper.waitUntil(editButton);
    }

    public void clickEditTeam() {
        WebDriverHelper.clickElement(editButton);
    }
    /**
     *
     * @param teamName
     */
    public void findTeamName(final String teamName) {
       this.teamName = WebDriverHelper.searchElement(By.xpath(String.format(this.teamNamePath, teamName)));
    }

    /**
     *
     * @return
     */
    public String getTeamName() {
        return WebDriverHelper.getTextElement(this.teamName);
    }

    /**
     *
     * @param teamDescription
     */
    public void findTeamDescription( String teamDescription) {
        this.teamDescription = WebDriverHelper.searchElement(By.xpath(String.format(this.teamDescriptionPath, teamDescription)));
    }

    /**
     *
     */
    public String getTeamDescription() {
        return WebDriverHelper.getTextElement(this.teamDescription);
    }

    public EditTeamForm getEditForm() {
        return this.editTeamForm;
    }

}
