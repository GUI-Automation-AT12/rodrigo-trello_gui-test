package core.selenium;

import core.selenium.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

public class WebDriverConfig {
    private static WebDriverConfig webDriverConfig;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Map<String, String> browsers;

    private WebDriverConfig() {
        browsers = new HashMap<>();
        browsers.put("Google Chrome", "config/browsers/chromeWebDriver.properties");
        browsers.put("Mozilla Firefox", "config/browsers/firefoxWebDriver.properties");
        browsers.put("Microsoft Edge", "config/browsers/edgeWebDriver.properties");
    }

    /**
     * Gets a singleton instance of the WebDriverManager.
     * @return WebDriverManager instance.
     */
    public static WebDriverConfig getInstance() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    public Map<String, String> getBrowserConfig() {
        return browsers;
    }
}
