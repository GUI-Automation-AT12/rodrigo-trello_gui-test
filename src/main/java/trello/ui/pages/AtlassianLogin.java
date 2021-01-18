package trello.ui.pages;

import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.JsonUser;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtlassianLogin extends InitialPage{
    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-submit")
    private WebElement loginSubmit;

    public AtlassianLogin() {
        WebDriverHelper.waitUntil(loginSubmit);
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
        WebDriverHelper.clickElement(loginSubmit);
    }
}
