package pageObjects;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import utils.AbstractPage;

@SuperBuilder
public class LandingPage extends AbstractPage {

    private final By search = By.className("search-keyword");
    private final By productName = By.className("product-name");
    private final By topDeals = By.linkText("Top Deals");

    public void searchItem(String item) {
        enterText(search, item);
    }

    public String getProductName() {
        return getText(productName);
    }

    public void openTopDeals() {
        click(topDeals);
    }
}
