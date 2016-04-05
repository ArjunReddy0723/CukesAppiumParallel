package com.cucumber.steps;

import com.appium.manager.BaseTestServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public class CucumberBaseTest extends DriverManager {

    public AppiumDriver<MobileElement> driver;
    public BaseTestServer appiumServer = new BaseTestServer();
	@Before
    public void beforeClass() throws Exception {
        driver = appiumServer.setUp();
        System.out.println("Inside Before"+Thread.currentThread().getId());

    }

    public AppiumDriver<MobileElement> getDriver(){
       return driver;
    }

    @After
    public void afterClass() throws InterruptedException, IOException {
        appiumServer.tearDown();
        System.out.println("Inside After"+Thread.currentThread().getId());
    }



}
