package todoly.ui;

import core.selenium.config.EnvironmentProperties;
import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtlassianLogin {
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-submit")
    WebElement loginSubmit;

    public AtlassianLogin() {
        setPassword();
        tryLogin();
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
        WebDriverHelper.clickElement(loginSubmit);
    }
}
