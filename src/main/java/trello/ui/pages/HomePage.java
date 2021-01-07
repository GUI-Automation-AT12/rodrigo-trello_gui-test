package trello.ui.pages;

import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends InitialPage{

    @FindBy(xpath = "(//nav[@class='home-left-sidebar-container']/div/ul/li)[last()-1]")
    WebElement boardsOption;

    @FindBy(xpath = "(//li[@data-test-id='templates']")
    WebElement templatesOption;

    @FindBy(xpath = "(//nav[@class='home-left-sidebar-container']/div/ul/li)[last()]")
    WebElement startOption;

    @FindBy(css = "div#content button[data-test-id='home-navigation-create-team-button']")
    WebElement createTeamButton;


    public HomePage() {
        WebDriverHelper.waitUntil(createTeamButton);
    }

    @Override
    protected void waitForElement(WebElement webElement) {

    }

    /**
     * click on boards.
     */
    private void clickBoards(){
        WebDriverHelper.clickElement(boardsOption);
    }

    /**
     * click on templates.
     */
    private void clickTemplates(){
        WebDriverHelper.clickElement(templatesOption);
    }

    /**
     * click on start section.
     */
    private void clickStartOption(){
        WebDriverHelper.clickElement(startOption);
    }

    /**
     *
     */
    public void clickCreateTeam() {
        WebDriverHelper.clickElement(createTeamButton);
    }
}
