package todoly.ui;

import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseLogin extends InitialPage{

    @FindBy(id = "user")
    WebElement user;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public BaseLogin() {
        setUser();
        setPassword();
        tryLogin();
    }

    /**
     * Set user
     */
    private void setUser(){
        WebDriverHelper.setElement(user, EnvironmentProperties.getInstance().getUsername());
    }

    /**
     * Set password
     */
    private void setPassword(){
        WebDriverHelper.setElement(password, EnvironmentProperties.getInstance().getPassword());
    }

    /**
     * click on login button
     */
    private void tryLogin(){
        WebDriverHelper.clickElement(loginButton);
    }


    @Override
    protected void waitForElement(WebElement webElement) {

    }
}
