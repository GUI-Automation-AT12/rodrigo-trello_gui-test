package trello.stepdefs.board;

import core.selenium.utils.Mapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import trello.context.Context;
import trello.entities.Board;
import trello.ui.PageTransporter;
import trello.ui.StringUtils;
import trello.ui.pages.BoardConfigurationPage;
import trello.ui.pages.CreateBoardPage;
import trello.ui.pages.HomePage;
import java.util.Map;

public class BoardStepdefs {

    private Board board;

    private Context context;

    /**
     * board step definitions.
     */
    public BoardStepdefs(final Context context) {
        this.context = context;
        board = new Board();
    }

    @When("I open the create board form")
    public void iOpenTheCreateBoardForm() {
        HomePage home =  new HomePage();
        PageTransporter.navigateToAccount(context.getValueData("name").concat("/home"));
        home.clickAddBoard();
    }

    @And("I put the following information on create board pop up")
    public void iPutTheFollowingInformationOnCreateBoardPopUp(Map<String, String> boardInformation) {
        boardInformation = Mapper.replaceId(boardInformation);
        CreateBoardPage boardPage = new CreateBoardPage();
        boardPage.createBoard(boardInformation);
        context.setBoard(boardPage.getBoard());
    }

    @Then("the board's information should match")
    public void theBoardSInformationShouldMatch() {
        BoardConfigurationPage boardConfigurationPage = new BoardConfigurationPage();
        Assert.assertEquals(boardConfigurationPage.getTitleText(), context.getBoard().getName());
    }

}
