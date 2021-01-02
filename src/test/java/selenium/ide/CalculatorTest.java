package selenium.ide;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
public class CalculatorTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculadora.org/");
        driver.manage().window().setSize(new Dimension(854, 1010));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void sum() {
        execute("6","4", "5", "9");
    }

    @Test
    public void subtraction() {
        execute("6","8", "5", "1");
    }

    private void execute (final String num1Position, final String num2Position, final String operatorPosition, final String result) {
        driver.findElement(By.cssSelector("span:nth-child("+num1Position+")")).click();
        driver.findElement(By.cssSelector(".operator:nth-child(" + operatorPosition + ")")).click();
        driver.findElement(By.cssSelector("span:nth-child(" + num2Position + ")")).click();
        driver.findElement(By.cssSelector(".eval")).click();
        assertEquals(driver.findElement(By.className("screen")), result);
    }
}
