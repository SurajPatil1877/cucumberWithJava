package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public record Hooks(TestContextSetup setup) {

    @After
    public void quitDriver() {
        WebDriver driver = setup.getTestBase().driver;
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshotAs = ((TakesScreenshot) setup.getTestBase().driver).getScreenshotAs(OutputType.FILE);
            byte[] img;
            try {
                img = FileUtils.readFileToByteArray(screenshotAs);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scenario.attach(img, "image/png", "image");
        }
    }
}
