package trello.entities;

import java.util.HashMap;
import java.util.Map;

public class Team {

    private String name;
    private String typeOfTeam;
    private String shortName;
    private String website;
    private String description;

    /**
     * Gets name of the team.
     * @return name of team
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the team.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets short name of the team.
     * @return shortName of the team
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets shortName of the team.
     * @param shortName
     */
    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets type of the team.
     * @return type of the team
     */
    public String getTypeOfTeam() {
        return typeOfTeam;
    }

    /**
     * Sets type of the team.
     * @param typeOfTeam
     */
    public void setTypeOfTeam(final String typeOfTeam) {
        this.typeOfTeam = typeOfTeam;
    }

    /**
     * Gets website of the team.
     * @return website of the team
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets type of the team.
     * @param website
     */
    public void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * Gets description of the team.
     * @return description of the team
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description of the team.
     * @param description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets team as map.
     * @return a entities team with as map.
     */
    public Map<String, String> getTeamAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("Name", getName());
        userInfoMap.put("Type", getTypeOfTeam());
        userInfoMap.put("Description", getDescription());
        return userInfoMap;
    }

    /**
     * Process user's information as a map.
     * @param teamInformation
     */
    public void processInformation(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(teamInformation);
        teamInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param teamInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(teamInformation.get("Name")));
        strategyMap.put("Type", () -> setTypeOfTeam(teamInformation.get("Type")));
        strategyMap.put("Description", () -> setDescription(teamInformation.get("Description")));
        return strategyMap;
    }
}
