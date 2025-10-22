package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageStepDef {
    private final TestContextSetup setup;
    private final LandingPage landingPage;

    public LandingPageStepDef(TestContextSetup setup) {
        this.setup = setup;
        this.landingPage = setup.getPageObjectManager().getLandingPage();
    }

    @Given("User is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() {
        landingPage.navigateToHomePage();
    }

    @When("^User searched with shortname (.+) and extracted actual name of a product$")
    public void enterShortProductNameAndExtractActualNameOfaProduct(String shortName) {
        landingPage.searchItem(shortName);
        landingPage.sleep(999);
        setup.setLandingPageProductName(landingPage.getProductName().split("-")[0].trim());
    }
}
