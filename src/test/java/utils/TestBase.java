package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    public WebDriver driver;

    public WebDriver setupDriver() {
        if (driver == null) {
            var options = new ChromeOptions();
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            return driver;
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
