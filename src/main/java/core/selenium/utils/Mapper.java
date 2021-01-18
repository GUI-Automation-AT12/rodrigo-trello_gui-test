package core.selenium.utils;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

    /**
     * Mapper constructor.
     */
    private Mapper() {
    }

    /**
     * @param storedValues
     * @return The new endPoint with params replaced.
     */
    public static Map<String, String> replaceId(final Map<String, String> storedValues) {
        IdGenerator idGenerator = new IdGenerator();
        Map<String, String> storedValuesUpdated= new HashMap<>();
        String idGenerated = idGenerator.getGeneratedId();
        for (Map.Entry<String, String> entry : storedValues.entrySet()) {
            storedValuesUpdated.put(entry.getKey(), entry.getValue().replace("UNIQUE_ID", idGenerated));
        }
        return storedValuesUpdated;
    }
}
