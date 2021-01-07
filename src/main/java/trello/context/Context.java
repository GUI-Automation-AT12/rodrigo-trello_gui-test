package todoly.context;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, String> map;

    /**
     * Constructor for the Context.
     */
    public Context() {
        this.map = new HashMap<>();
    }

    /**
     * This method save data in the map.
     */
    public void saveData(final String key, final String value) {
        this.map.put(key, value);
    }

    /**
     * This method returns the map.
     */
    public Map<String, String> getMap() {
        return this.map;
    }

    /**
     * This method returns an specific value.
     */
    public String getValue(final String key) {
        return this.map.get(key);
    }
}
