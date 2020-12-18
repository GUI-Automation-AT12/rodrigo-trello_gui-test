package core.selenium;

import core.selenium.config.WebDriverEnvironment;
import core.selenium.utils.WebDriverStarter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private  WebDriverStarter webDriverStarter;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        webDriverStarter = new WebDriverStarter();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(WebDriverEnvironment.getInstance().getImplicitTime()), TimeUnit.SECONDS);
        webDriverWait =  new WebDriverWait(webDriver, Integer.parseInt(WebDriverEnvironment.getInstance().getExplicitTime()));
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
}
