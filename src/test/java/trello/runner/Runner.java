package trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/"},
        glue = {""}
)
public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}