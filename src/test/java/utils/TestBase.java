package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    private Properties properties;

    public WebDriver setupDriver() {
        if (driver == null) {
            initProperties();
            intDriver();
            driver
                    .navigate()
                    .to(properties.getProperty("url"));
            return driver;
        }
        return driver;
    }

    private void intDriver() {
        String browser = properties.getProperty("browser").toLowerCase();
        driver = switch (browser) {
            case "chrome" -> {
                WebDriverManager
                        .chromedriver()
                        .setup();
                var options = new ChromeOptions()
                        .addArguments("--start-maximized");
                yield new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager
                        .firefoxdriver()
                        .setup();
                var options = new FirefoxOptions()
                        .addArguments("--start-maximized");
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                WebDriverManager
                        .edgedriver()
                        .setup();
                var edgeOptions = new EdgeOptions()
                        .addArguments("--start-maximized");
                yield new EdgeDriver(edgeOptions);
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        };
    }

    private void initProperties() {
        String property = System.getProperty("user.dir") + "//src//test//resources//global.properties";
        try (FileInputStream fis = new FileInputStream(property)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
