package com.appium.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTestServer {
    public AppiumDriver<MobileElement> driver;
	AppiumServer server = new AppiumServer();

    String[] devices={"192.168.56.101:5555","192.168.56.102:5555"};
   
	DesiredCapabilities capabilities = new DesiredCapabilities();

	public AppiumDriver<MobileElement> setUp() throws Exception{
		System.out.println("*****threadcount***"+ (Integer.valueOf(Thread.currentThread().getName().split("-")[3]) - 1));		
		int thread_device_count = Integer.valueOf(Thread.currentThread().getName().split("-")[3]) - 1;		
		server.appiumServer(devices[thread_device_count]);
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("platformVersion", "5.X");
		capabilities.setCapability("app","/Users/saikrisv/Documents/workspace/workspace1/TestNGParallelThreadBeforeClass/build/AndroidCalculator.apk");
		capabilities.setCapability("package","com.android2.calculator3");
		capabilities.setCapability("appActivity", "com.android2.calculator3.Calculator");	
		Thread.sleep(5000);
		return driver = new AndroidDriver<>(server.getAppiumUrl(), capabilities);
	}
	

	public void tearDown(){
		server.destroyAppiumNode();
	}
	
	
}
