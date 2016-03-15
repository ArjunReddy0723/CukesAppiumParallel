package com.cucumber.steps;

import com.appium.manager.AppiumParallelTest;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

/**
 * Created by saikrisv on 09/03/16.
 */
public class LoginSteps{
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

    @Given("^i'm on homepage$")
    public void iMOnHomepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^i click on login$")
    public void iClickOnLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^i should see login editbox$")
    public void iShouldSeeLoginEditbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
