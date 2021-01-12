package core.selenium.WebBrowsers;

import org.openqa.selenium.WebDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserDriver implements IDriver {

    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("84.0.2").setup();
        return new FirefoxDriver();
    }
}
