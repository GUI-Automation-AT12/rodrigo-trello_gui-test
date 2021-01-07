package trello.ui;

import core.selenium.WebDriverManager;
import core.selenium.config.EnvironmentProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * PageTransporter Class.
 */
public final class PageTransporter {
    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        PAGE_URL.put("LOGIN", "login");
        PAGE_URL.put("HOME", "home");
        PAGE_URL.put("BOARD", "boards");
    }

    private PageTransporter() {

    }

    /**
     * Navigate to URL.
     * @param pageName
     */
    public static void navigateToPage(final String pageName) {
        navigateToUrl(EnvironmentProperties.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    /**
     * Navigate to URL.
     * @param url
     */
    private static void navigateToUrl(final String url) {
        try {
            WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException("This url is invalid: " + e.getMessage());
        }
    }
}
