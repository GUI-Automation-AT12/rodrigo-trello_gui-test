package core.selenium;

import core.selenium.WebBrowsers.FactoryBrowserDriver;
import core.selenium.config.EnvironmentProperties;
import core.selenium.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        webDriver = FactoryBrowserDriver.getBrowser();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(
                WebDriverEnvironment.getInstance(
                        WebDriverConfig.getInstance().getBrowserConfig().get(EnvironmentProperties.getInstance().getBrowser())
                ).getImplicitTime()),
                TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, Integer.parseInt(
                WebDriverEnvironment.getInstance(
                        WebDriverConfig.getInstance().getBrowserConfig().get(EnvironmentProperties.getInstance().getBrowser())
                ).getExplicitTime())
        );
    }

    /**
     * Gets a singleton instance of the WebDriverManager.
     * @return WebDriverManager instance.
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public  WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public  WebDriver getWebDriver() {
        return webDriver;
    }

    public void quitWebDriver()
    {
        webDriver.quit();
        webDriverManager =  null;
    }
}
