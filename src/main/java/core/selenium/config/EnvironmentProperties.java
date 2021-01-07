package core.selenium.config;

public class EnvironmentProperties extends PropertiesReader {
    private static final String GRADLE_FILE = "gradle.properties";
    private static EnvironmentProperties environment;
    /**
     * Initializes an instance of properties files.
     */
    public EnvironmentProperties() {
        super(GRADLE_FILE);
    }

    /**
     * Gets a singleton instance of the PivotalEnvironment.
     * @return PivotalEnvironment instance.
     */
    public static EnvironmentProperties getInstance() {
        if (environment == null) {
            environment = new EnvironmentProperties();
        }
        return environment;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return getEnvProperty("baseUrl");
    }

    /**
     * get the schemasPath from the file.properties.
     *
     * @return schemasPath value.
     */
    public String getUsername() {
        return getEnvProperty("username");
    }

    /**
     * get the cucumberThreadCount from the file.properties.
     *
     * @return cucumberThreadCount value.
     */
    public String getPassword() {
        return getEnvProperty("password");
    }

    /**
     * get the schemasPath from the file.properties.
     *
     * @return schemasPath value.
     */
    public String getFilterTags() {
        return getEnvProperty("filterTags");
    }

    /**
     * get the cucumberThreadCount from the file.properties.
     *
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return getEnvProperty("cucumberThreadCount");
    }

    /**
     * get the browser from the file.properties.
     *
     * @return browser value.
     */
    public String getBrowser() {
        return getEnvProperty("browser");
    }

}
