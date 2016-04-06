package com.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SampleSteps{

    public AppiumDriver<MobileElement> driver;
    public CucumberBaseTest cucumberBaseTest = new CucumberBaseTest();
    public SampleSteps() {
        this.driver = cucumberBaseTest.getDriver();
    }

    @Given("^I have the this useless scenario$")
    public void uselessScenario() {
        System.out.println("Passed");
        System.out.println("*****DriverSession***" + driver.toString());
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
