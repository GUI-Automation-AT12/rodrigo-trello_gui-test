package core.selenium.utils;

import core.selenium.config.WebDriverEnvironment;

/**
 * WebDriverStarter
 */
public class WebDriverStarter {
    private String path = "webdriver.chrome.driver";
    private String webDriverInstance;

    public WebDriverStarter() {
        webDriverInstance = WebDriverEnvironment.getInstance().getDriverChromePath();
        setProperty();
    }

    private void setProperty (){
        System.setProperty(path, webDriverInstance);
    }
}
