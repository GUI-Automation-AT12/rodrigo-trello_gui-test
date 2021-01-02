package core.selenium.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesReader class.
 */
public class PropertiesReader {
    private Properties property;
    private FileReader reader;

    /**
     * Initializes an instance of properties files.
     *
     * @param propertiesPath
     */
    public PropertiesReader(final String propertiesPath) {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            closeReader();
        }
    }

    /**
     * Gets environment property.
     * @param env
     * @return property value.
     */
    protected String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
