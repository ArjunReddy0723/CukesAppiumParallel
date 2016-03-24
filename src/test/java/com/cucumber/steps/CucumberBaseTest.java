package com.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class CucumberBaseTest{
	
	@Before
    public void beforeClass() throws Exception {
        System.out.println("Inside Before"+Thread.currentThread().getId());

    }

    @After
    public void afterClass() throws InterruptedException, IOException {
        System.out.println("Inside After"+Thread.currentThread().getId());
    }



}
