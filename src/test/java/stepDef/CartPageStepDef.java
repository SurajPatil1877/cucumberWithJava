package stepDef;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CartPageStepDef {
    private final TestContextSetup setup;
    private final CartPage cartPage;
    private final LandingPage landingPage;

    public CartPageStepDef(TestContextSetup setup) {
        this.setup = setup;
        this.landingPage = setup
                .getPageObjectManager()
                .getLandingPage();
        this.cartPage = setup
                .getPageObjectManager()
                .getCartPage();
    }

    @And("Validate the product details on cart page")
    public void validateDetailsOnCartPage() {
        landingPage.openCart();
        Assert.assertEquals(cartPage.getProductName().split("-")[0].trim(), setup.getLandingPageProductName(), "Product name is not Matching");
        Assert.assertEquals(cartPage.getProductQuantity(), setup.getProductQuantity(), "Product Quantity is not matching");
        Assert.assertTrue(cartPage.presenceOfApplyButton(), "Apply Button is not present");
        Assert.assertTrue(cartPage.presenceOfPlaceOrder(), "Place Order Button is not present");
    }
}
