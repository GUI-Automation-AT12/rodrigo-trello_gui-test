package core.selenium.utils;

import org.openqa.selenium.WebElement;

public final class WebDriverHelper {

    public WebDriverHelper() {
    }

    public  static void setElement(final WebElement webElement, final String element) {
        webElement.clear();
        webElement.sendKeys(element);
    }

    public  static void clickElement(final WebElement webElement) {
        webElement.click();
    }
}
