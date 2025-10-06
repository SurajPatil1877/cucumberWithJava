package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinations",
        tags = "@Smoke and @Regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        },
        monochrome = true)
public class RegressionAndSmokeTestNGRunner extends AbstractTestNGCucumberTests {
}
