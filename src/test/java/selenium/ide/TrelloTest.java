package selenium.ide;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TrelloTest {
    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://trello.com/login");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void createproject() {
        driver.findElement(By.cssSelector(".icon-add")).click();
        driver.findElement(By.xpath("//div[@id=\'layer-manager-overlay\']/div/div/div/div/form/input")).click();
        driver.findElement(By.xpath("//div[@id=\'layer-manager-overlay\']/div/div/div/div/form/input")).sendKeys("test");
        driver.findElement(By.xpath("//div[@id=\'layer-manager-overlay\']/div/div/div/div/form/div/div/div/div")).click();
        driver.findElement(By.cssSelector("#react-select-2-option-0 > .\\_38pq5NbRWAG39y")).click();
        driver.findElement(By.cssSelector(".X1P6DVryq8CYGC")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.linkText("Más tarde")).click();
        driver.findElement(By.cssSelector(".\\_2DZdmHnY2Nw7gI")).click();
        driver.findElement(By.cssSelector(".voB8NatlbuEme5:nth-child(7)")).click();
        driver.findElement(By.cssSelector(".\\_1WD42rQsKIT-I6 .sc-bdVaJa")).click();
        driver.findElement(By.cssSelector(".pgEbaAFZBA0N5R:nth-child(4) > .IAUH08xqIilxIq > .\\_3qwe2tMMFonNvf")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".pgEbaAFZBA0N5R:nth-child(4) > .IAUH08xqIilxIq > .\\_3qwe2tMMFonNvf"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".quiet-button > span")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".js-confirm")).click();
    }
}
