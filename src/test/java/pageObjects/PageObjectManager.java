package pageObjects;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class PageObjectManager {
    private LandingPage landingPage;
    private OffersPage offersPage;
    private final WebDriver driver;
    private CartPage cartPage;

    public LandingPage getLandingPage() {
        if (landingPage != null) return landingPage;

        landingPage = LandingPage.builder().driver(driver).build();
        return landingPage;
    }

    public OffersPage getOffersPage() {
        if (offersPage != null) return offersPage;

        offersPage = OffersPage.builder().driver(driver).build();
        return offersPage;
    }

    public CartPage getCartPage() {
        if (cartPage != null) return cartPage;
        cartPage = CartPage.builder().driver(driver).build();
        return cartPage;
    }

}
