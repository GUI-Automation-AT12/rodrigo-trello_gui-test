package trello.ui.pages;

import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoardPage {

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']")
    WebElement boardTitle;

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/parent::div/button[2]/span[last()-1]")
    WebElement team;

    @FindBy(xpath = "//button[@data-test-id='create-board-submit-button']")
    WebElement createButton;

    @FindBy(xpath = "//button[@data-test-id='create-board-submit-button']/following-sibling::a")
    WebElement templateButton;

    public CreateBoardPage() {

    }

    /**
     * Set title
     */
    private void setTitle() {
        WebDriverHelper.setElement(boardTitle, "demoExample");
    }

    /**
     * Set title
     */
    private void setTeam() {
        WebDriverHelper.setElement(team, "at13");
    }

    /**
     * click on create button
     */
    private void tryCreating() {
        WebDriverHelper.clickElement(createButton);
    }

    /**
     * start using a template button
     */
    private void tryTemplate() {
        WebDriverHelper.clickElement(templateButton);
    }
}
