package trello.entities;

import trello.ui.StringUtils;

public class Board {

    private String name;
    private String team;
    private String privacy;

    /**
     * Gets name of the board.
     * @return name of board
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the board.
     * @param nameBoard
     */
    public void setName(final String nameBoard) {
        this.name = nameBoard;
    }

    /**
     * Gets slug name of the board.
     * @return slug name of the board
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets name of the board.
     * @param teamName
     */
    public void setTeam(final String teamName) {
        this.team = StringUtils.replaceBlankSpaces(teamName);
    }

    /**
     * Gets the privacy.
     * @return board privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets board privacy.
     * @param privacy
     */
    public void setPrivacy(final String privacy) {
        this.privacy = privacy;
    }

}
