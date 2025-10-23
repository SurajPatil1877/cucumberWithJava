package hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class Hooks {
    private final TestContextSetup setup;

    public Hooks(TestContextSetup setup) {
        this.setup = setup;
    }

    @After
    public void quitDriver() {
        WebDriver driver = setup.getTestBase().driver;
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
