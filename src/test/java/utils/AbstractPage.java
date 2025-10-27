package utils;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@SuperBuilder
public abstract class AbstractPage {

    protected final WebDriver driver;

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchTab() {
        var tabs = driver
                .getWindowHandles()
                .stream()
                .toList();
        driver
                .switchTo()
                .window(tabs.get(1));
    }

  public String getTitle(){
        return driver.getTitle();
  }

    public void enterText(By by, String text) {
        findElement(by)
                .sendKeys(text);
    }

    public String getText(By by) {
        return findElement(by)
                .getText();
    }

    public void click(By by) {
        findElement(by)
                .click();
    }

    public void waitTillElementIsLocated(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean elementIsPresent(By by){
        return driver.findElement(by).isDisplayed();
    }

    private WebElement findElement(By by) {
        return driver.findElement(by);
    }


}
