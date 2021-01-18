package trello.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.JsonUser;
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
        WebDriverManager.getInstance().getWebDriver().navigate().to(EnvironmentProperties.getInstance().getBaseUrl());
        PageTransporter.navigateToPage("login");
        setEmail();
        setPassword();
        tryLogin();
    }

    /**
     * Set user
     */
    public void setEmail(){
        WebDriverHelper.setElement(user, JsonUser.getInstance().getEmail());
    }

    /**
     * Set password
     */
    public void setPassword(){
        WebDriverHelper.setElement(password, JsonUser.getInstance().getPassword());
    }

    /**
     * click on login button
     */
    public void tryLogin(){
        WebDriverHelper.clickElement(loginButton);
    }

}
