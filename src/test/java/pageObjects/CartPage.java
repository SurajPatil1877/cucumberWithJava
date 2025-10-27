package pageObjects;

import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import utils.AbstractPage;

@SuperBuilder
public class CartPage extends AbstractPage {
    private final By productName = By.className("product-name");
    private final By productQuantity = By.className("quantity");
    private final By applyButton = By.className("promoBtn");
    private final By placeOrder = By.xpath("//button[text()='Place Order']");


    public String getProductName() {
        return getText(productName);
    }

    public int getProductQuantity() {
        return Integer.parseInt(getText(productQuantity));
    }

    public boolean presenceOfApplyButton() {
        return elementIsPresent(applyButton);
    }

    public boolean presenceOfPlaceOrder() {
        return elementIsPresent(placeOrder);
    }
}
