package learning.cucumber.stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    @Before("@Netbanking")
    public void netBankingSetup() {
        System.err.println("Netbanking Setup");
    }

    @Before("@Mortgage")
    public void mortgageSetup() {
        System.err.println("Mortgage Setup");
    }

    @After()
    public void tearDown() {
        System.err.println("Tear Down");
    }
}
