package trello.fillforms;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class FillFormCreateBoard implements FillFormStrategy {

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']")
    WebElement boardTitle;

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/parent::div/button[2]/span[last()-1]")
    WebElement team;

    @Override
    public boolean fill(Map<String, String> data) {
        return false;
    }

    @Override
    public void sendForm() {

    }

    private void setBoardTitle(final String email) {
        WebDriverHelper.setElement(this.boardTitle, email);
    }

    private void setTeam(final String email) {
        WebDriverHelper.setElement(this.team, email);
    }

}
