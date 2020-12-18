package todoly.ui;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage {

    @FindBy(css = "open-add-list js-open-add-list")
    WebElement addList;

    @FindBy(xpath = "(//a[@class='open-card-composer js-open-card-composer'])[last()]")
    WebElement AddCard;

    @FindBy(xpath = "//span[@id='workspaces-preamble-invite-button']//a")
    WebElement inviteButton;

    @FindBy(id = "permission-level")
    WebElement seePermissionLvlButton;

    public BoardPage() {

    }

    /**
     * add list.
     */
    private void addList(){
        WebDriverHelper.clickElement(addList);
    }

    /**
     * add a new card.
     */
    private void AddCard(){
        WebDriverHelper.clickElement(AddCard);
    }

    /**
     * open invite pop up.
     */
    private void clickInvite(){
        WebDriverHelper.clickElement(inviteButton);
    }

    /**
     * open permissions pop up.
     */
    private void openPermissions(){
        WebDriverHelper.clickElement(seePermissionLvlButton);
    }


}
