package com.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleSteps {
    @Given("^I have the this useless scenario$")
    public void uselessScenario() {
        System.out.println("Passed");
    }

    @When("^I sleep for (\\d+) seconds$")
    public void I_sleep_for_seconds(int arg1) throws InterruptedException {
        Thread.sleep(arg1 * 1000);
        System.out.println("Passed");
    }

    @Then("^It should finnish$")
    public void It_should_finnish() {
        System.out.println("Passed");
    }
}
