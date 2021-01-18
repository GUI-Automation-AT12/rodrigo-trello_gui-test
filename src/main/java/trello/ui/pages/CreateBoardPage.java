package trello.ui.pages;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.entities.Board;

import java.util.Map;

public class CreateBoardPage extends InitialPage{

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    WebElement boardTitle;

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/parent::div/button[2]/span[last()-1]")
    WebElement team;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    WebElement createButton;

    @FindBy(css = "button[data-test-id='create-board-submit-button']/following-sibling::a")
    WebElement templateButton;

    private Board board;

    public CreateBoardPage() {
        board = new Board();
    }

    /**
     * Set title
     */
    private void setTitle(final String title) {
        WebDriverHelper.setElement(boardTitle, title);
    }

    /**
     * Set title
     */
    private void setTeam(final String team) {
        WebDriverHelper.setElement(this.team, team);
    }

    /**
     * click on create button
     */
    private void tryCreating() {
        WebDriverHelper.clickElement(createButton);
    }

    /**
     * start using a template button
     */
    private void tryTemplate() {
        WebDriverHelper.clickElement(templateButton);
    }

    /**
     * Create a board.
     * @param boardInformation
     */
    public void createBoard(Map<String, String> boardInformation) {
        board.processInformation(boardInformation);
        setTitle(board.getName());
        tryCreating();
    }

    /**
     * get the board entity.
     * @return
     */
    public Board getBoard() {
        return board;
    }

    public void setBoard(final Board board) {
        this.board =  board;
    }
}
