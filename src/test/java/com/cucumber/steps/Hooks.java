package com.cucumber.steps;

import com.appium.manager.BaseTestServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public class Hooks extends DriverManager{

    public BaseTestServer appiumServer = new BaseTestServer();
    AppiumDriver<MobileElement> driver;

	@Before
    public void beforeClass() throws Exception {
        driver = appiumServer.setUp();
        setWebDriver(driver);
        System.out.println("Inside Before"+Thread.currentThread().getId());
    }


    @After
    public void afterClass() throws InterruptedException, IOException {
        appiumServer.tearDown();
        System.out.println("Inside After"+Thread.currentThread().getId());
    }



}
