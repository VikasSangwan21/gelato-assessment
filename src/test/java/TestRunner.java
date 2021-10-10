import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "src/test/java/features",
        glue = "stepDef",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
