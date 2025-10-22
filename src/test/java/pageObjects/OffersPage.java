package pageObjects;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import utils.AbstractPage;

@SuperBuilder
public class OffersPage extends AbstractPage {

    private final By searchField = By.id("search-field");
    private final By firstProductName = By.cssSelector("tr td:nth-child(1)");

    public void searchProduct(String item) {
        enterText(searchField, item);
    }

    public String getProductName() {
        return getText(firstProductName);
    }
}
