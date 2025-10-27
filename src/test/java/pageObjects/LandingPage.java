package pageObjects;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.AbstractPage;

@SuperBuilder
public class LandingPage extends AbstractPage {

    private final By search = By.className("search-keyword");
    private final By productName = By.className("product-name");
    private final By topDeals = By.linkText("Top Deals");
    private final By increment = By.className("increment");
    private final By addToCart = By.xpath("//button[text()='ADD TO CART']");
    private final By cart = By.xpath("//img[@alt='Cart']");
    private final By proceedToCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public void searchItem(String item) {
        enterText(search, item);
    }

    public String getProductName() {
        return getText(productName);
    }

    public void openTopDeals() {
        click(topDeals);
    }

    public void validateTitle() {
        String expected = "GreenKart - veg and fruits kart";
        String actual = getTitle();
        Assert.assertEquals(actual, expected, "Title is not matching");
    }

    public void increaseQuantityOfAProduct(int quantity) {
        for (int i = 0; i < quantity - 1; i++) click(increment);
    }

    public void addToCart() {
        click(addToCart);
    }

    public void openCart() {
        click(cart);
        click(proceedToCheckout);
        sleep(1999);
    }
}
