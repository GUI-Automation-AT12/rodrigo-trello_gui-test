package trello.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class InitialPage {

    @FindBy(xpath = "//a[@href= '/login']")
    private WebElement loginButton;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    public InitialPage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDriver, this);
    }

    public void openLogin() {
        WebDriverHelper.clickElement(loginButton);
    }
}
