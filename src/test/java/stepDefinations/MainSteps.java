package stepDefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class MainSteps {
    @Given("User is on NetBanking Landing Page")
    public void user_is_on_net_banking_landing_page() {
        System.out.println("User is on NetBanking Landing Page");
    }

    @When("^User login into application with (.+) and password (.+)$")
    public void user_login_into_application_with_and(String username, String password) {
        System.out.println("User login into application with " + username + " and " + password);
    }

//    @When("User login into application with {string} and password {string}")
//    public void user_login_into_application_with_and(String username, String password) {
//        System.out.println("User login into application with " + username + " and " + password);
//    }

    @Then("Home page is displayed")
    public void home_page_is_displayed() {
        System.out.println("Home page is displayed");
    }

    @And("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");
    }

    @Given("User is on Practice Landing Page")
    public void userIsOnPracticeLandingPage() {
        System.out.println("Landing Page");
    }

    @When("User signup into application with following details")
    public void userSignupIntoApplicationWithFollowingDetails(Map<String, String> data) {
        System.out.println(data.get("firstName"));
        System.out.println(data.get("lastName"));
        System.out.println(data.get("email"));
        System.out.println(data.get("mobile"));
    }
}
