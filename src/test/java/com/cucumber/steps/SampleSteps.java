package com.cucumber.steps;

import com.appium.manager.AppiumParallelTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public class SampleSteps{
    AppiumParallelTest appiumParallelTest = new AppiumParallelTest();
    AppiumDriver<MobileElement> driver ;
    @Before
    public void beforeClass() throws Exception {
        System.out.println("Inside Before");
        appiumParallelTest.startAppiumServer(getClass().getSimpleName());
        driver = appiumParallelTest.startAppiumServerInParallel();
    }

    @After
    public void afterClass() throws InterruptedException, IOException {
        appiumParallelTest.killAppiumServer();
    }

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
