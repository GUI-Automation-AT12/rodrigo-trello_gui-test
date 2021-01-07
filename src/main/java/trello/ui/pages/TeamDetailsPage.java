package trello.ui.pages;

import core.selenium.utils.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamDetailsPage {

    @FindBy( id = "displayName")
    WebElement name;

    @FindBy(id = "name")
    WebElement shortName;

    @FindBy(id = "website")
    WebElement website;

    @FindBy(id = "desc")
    WebElement desc;

    public TeamDetailsPage() {
    }

    /**
     * set name.
     */
    private void setName(final String givenName){
        WebDriverHelper.setElement(name, givenName);
    }

    /**
     * set short name.
     */
    private void setShortName(final String shortName){
        WebDriverHelper.setElement(this.shortName, shortName);
    }

    /**
     * set website.
     */
    private void setWebsite(final String website){
        WebDriverHelper.setElement(this.website, website);
    }

    /**
     * set description.
     */
    private void setDesc(final String description){
        WebDriverHelper.setElement(desc, description);
    }
}
