package core.selenium.WebBrowsers;

import org.openqa.selenium.WebDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDriver implements IDriver {

    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
