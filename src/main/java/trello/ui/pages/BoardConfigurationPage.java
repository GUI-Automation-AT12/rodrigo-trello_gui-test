package trello.ui.pages;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardConfigurationPage extends InitialPage{

    @FindBy(css = "h1[class='js-board-editing-target board-header-btn-text']")
    WebElement boardTitle;

    public BoardConfigurationPage() {
        WebDriverHelper.waitUntil(boardTitle);
    }

    public String getTitleText() {
        return WebDriverHelper.getTextElement(boardTitle);
    }
}
