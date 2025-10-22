package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

import java.util.Objects;


public class OfferPageStepDef {

    private final TestContextSetup setup;
    private final OffersPage offersPage;
    private final LandingPage landingPage;

    public OfferPageStepDef(TestContextSetup setup) {
        this.setup = setup;
        this.landingPage = setup.getPageObjectManager().getLandingPage();
        this.offersPage = setup.getPageObjectManager().getOffersPage();
    }

    public void switchToOffersPage() {
        if (Objects.requireNonNull(offersPage.getCurrentURL()).contains("offers")) return;
        landingPage.openTopDeals();
        offersPage.sleep(999);
        offersPage.switchTab();
    }

    @Then("^User search of same shortname (.+) in offers page to check if product exists$")
    public void searchShortNameInOffersPageToCheckIfProductExists(String shortName) {
        switchToOffersPage();
        offersPage.searchProduct(shortName);
        offersPage.sleep(999);
        setup.setOffersPageProductName(offersPage.getProductName());
    }

    @And("Validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(setup.getOffersPageProductName(), setup.getLandingPageProductName(), "Product Name is not matching");
    }
}
