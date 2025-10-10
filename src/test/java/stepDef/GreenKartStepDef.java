package stepDef;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GreenKartStepDef extends TestBase {


    private String productName;

    @Given("User is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() {
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("^User searched with shortname (.+) and extracted actual name of a product$")
    public void enterShortProductNameAndExtractActualNameOfaProduct(String shortName) {
        driver.findElement(By.className("search-keyword")).sendKeys(shortName);
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productName = driver.findElement(By.className("product-name")).getText().split("-")[0].trim();
    }

    @Then("^User search of same shortname (.+) in offers page to check if product exists$")
    public void searchShortNameInOffersPageToCheckIfProductExists(String shortName) {
        driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("search-field")).sendKeys(shortName);
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement table = driver.findElement(By.xpath("//table"));
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
        String actualName = rows.getFirst().findElements(By.tagName("td")).getFirst().getText();
        Assert.assertEquals(actualName, productName, "Product Name is not matching");
    }
}
