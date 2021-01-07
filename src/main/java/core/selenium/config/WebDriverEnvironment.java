package core.selenium.config;

public final class WebDriverEnvironment extends PropertiesReader {
    private static final String GRADLE_FILE = "chromeWebDiver.properties";
    private static WebDriverEnvironment environment;
    /**
     * Initializes an instance of properties files.
     */
    private WebDriverEnvironment() {
        super(GRADLE_FILE);
    }

    /**
     * Gets a singleton instance of the WebDriverEnvironment.
     * @return WebDriverEnvironment instance.
     */
    public static WebDriverEnvironment getInstance() {
        if (environment == null) {
            environment = new WebDriverEnvironment();
        }
        return environment;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getDriverChromePath() {
        return getEnvProperty("driverChromePath");
    }

    /**
     * get the implicitTime from the file.properties.
     *
     * @return implicitTime value.
     */
    public String getImplicitTime() {
        return getEnvProperty("implicitTime");
    }

    /**
     * get the cucumberThreadCount from the file.properties.
     *
     * @return cucumberThreadCount value.
     */
    public String getExplicitTime() {
        return getEnvProperty("explicitTime");
    }

}
