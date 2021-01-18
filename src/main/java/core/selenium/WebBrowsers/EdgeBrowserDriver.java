package core.selenium.WebBrowsers;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;

public class EdgeBrowserDriver implements IDriver {

    public WebDriver initDriver() {
        EdgeDriverManager.getInstance(EDGE).version("87.0.664.75").setup();
        return new EdgeDriver();
    }
}
