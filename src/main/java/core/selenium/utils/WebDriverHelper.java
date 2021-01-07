package core.selenium.utils;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverHelper {

    public WebDriverHelper() {
    }

    public static void setElement(final WebElement webElement, final String element) {
        webElement.clear();
        webElement.sendKeys(element);
    }

    public static void clickElement(final WebElement webElement) {
        webElement.click();
    }

    /**
     * Method wait to load a webElement.
     * @param webElement
     */
    public static void waitUntil(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
