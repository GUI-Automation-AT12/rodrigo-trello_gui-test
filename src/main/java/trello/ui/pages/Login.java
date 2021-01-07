package trello.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.ui.PageTransporter;

public class Login extends InitialPage{

    @FindBy(id = "user")
    WebElement user;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public Login() {
        WebDriverManager.getInstance().getWebDriver().navigate().to("https://trello.com/");
        PageTransporter.navigateToPage("login");
        setUser();
        setPassword();
        tryLogin();
    }

    /**
     * Set user
     */
    public void setUser(){
        WebDriverHelper.setElement(user, EnvironmentProperties.getInstance().getUsername());
    }

    /**
     * Set password
     */
    public void setPassword(){
        WebDriverHelper.setElement(password, EnvironmentProperties.getInstance().getPassword());
    }

    /**
     * click on login button
     */
    public void tryLogin(){
        WebDriverHelper.clickElement(loginButton);
    }

    @Override
    protected void waitForElement(WebElement webElement) {

    }
}
