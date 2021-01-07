package core.selenium.config;

public final class WebDriverEnvironment extends PropertiesReader {
    private static WebDriverEnvironment environment;
    /**
     * Initializes an instance of properties files.
     */
    private WebDriverEnvironment(final String path) {
        super(path);
    }

    /**
     * Gets a singleton instance of the WebDriverEnvironment.
     * @return WebDriverEnvironment instance.
     */
    public static WebDriverEnvironment getInstance(final String path) {
        if (environment == null) {
            environment = new WebDriverEnvironment(path);
        }
        return environment;
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
