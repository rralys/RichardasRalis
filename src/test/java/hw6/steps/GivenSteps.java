package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;

public class GivenSteps extends BaseStep {

    @Given("I am on the index page")
    public void openTheIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/");
    }
}
