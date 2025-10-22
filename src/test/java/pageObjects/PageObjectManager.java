package pageObjects;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class PageObjectManager {
    private LandingPage landingPage;
    private OffersPage offersPage;
    private final WebDriver driver;


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

}
