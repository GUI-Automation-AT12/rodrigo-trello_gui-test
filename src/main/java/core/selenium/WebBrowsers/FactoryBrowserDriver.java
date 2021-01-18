package core.selenium.WebBrowsers;

import core.selenium.config.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import java.util.HashMap;
import java.util.Map;

public class FactoryBrowserDriver {

    public static WebDriver getBrowser(){
        Map<String,IDriver> factory = new HashMap<>();
        factory.put(FIREFOX.toString(), new FirefoxBrowserDriver());
        factory.put(CHROME.toString(), new ChromeBrowserDriver());
        factory.put(EDGE.toString(), new EdgeBrowserDriver());
        return factory.get(EnvironmentProperties.getInstance().getBrowser()).initDriver();
    }
}
