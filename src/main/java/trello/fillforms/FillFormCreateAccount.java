package todoly.fillforms;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class FillFormCreateAccount implements FillFormStrategy {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "displayName")
    WebElement name;

    @FindBy(id = "password")
    WebElement password;
    @Override
    public boolean fill(Map<String, String> data) {
        return false;
    }

    @Override
    public void sendForm() {

    }

    private void setEmail(final String email) {
        WebDriverHelper.setElement(this.email, email);
    }

    private void setName(final String email) {
        WebDriverHelper.setElement(this.name, email);
    }

    private void setPassword(final String email) {
        WebDriverHelper.setElement(this.password, email);
    }
}
