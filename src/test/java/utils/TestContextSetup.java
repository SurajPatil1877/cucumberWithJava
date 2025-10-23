package utils;

import lombok.Getter;
import lombok.Setter;
import pageObjects.PageObjectManager;

@Getter
public class TestContextSetup {

    @Setter
    private String landingPageProductName;
    @Setter
    private String offersPageProductName;

    private final PageObjectManager pageObjectManager;
    private final TestBase testBase;

    public TestContextSetup() {
        this.testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.setupDriver());
    }

}
