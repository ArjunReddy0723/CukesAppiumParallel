package com.appium.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.URL;

/**
 * Appium Manager - this class contains method to start and stops appium server
 * To execute the tests from eclipse, you need to set PATH as
 * /usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin in run configuration
 */
public class AppiumServer {
    public  AppiumDriver<MobileElement> driver;
	// CommandPrompt cp = new CommandPrompt();
	AvailabelPorts ap = new AvailabelPorts();
	AppiumDriverLocalService appiumDriverLocalService;
    public AppiumServiceBuilder builder = new AppiumServiceBuilder();
	/**
	 * start appium with default arguments
	 */
	public void startDefaultAppium() throws Exception {
		// cp.runCommand("appium --session-override");
		Thread.sleep(5000);
	}

	/**
	 * start appium with auto generated ports : appium port, chrome port,
	 * bootstrap port and device UDID
	 */

	public AppiumServiceBuilder appiumServer(String deviceID) throws Exception {
				System.out.println("Starting Appium Server");
				System.out.println(deviceID);
				System.out.println("Attempt to get port..");
				int port = ap.getPort();
				System.out.println("Port " + port);
				System.out.println("Attempt to get chrome port..");
				int chromePort = ap.getPort();
				System.out.println("Chrome port " + chromePort);
				System.out.println("Attempt to get bootstrap port..");
				int bootstrapPort = ap.getPort();
				System.out.println("Bootstrap port" + bootstrapPort);
				Thread.currentThread().sleep(5000);
				System.out.println("Attempt to start server with deviceID" + deviceID);
				builder.
						withAppiumJS(new File("/Users/saikrisv/git/appium_master/appium/build/lib/main.js")).
								withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
						.withArgument(GeneralServerFlag.UIID, deviceID)
						.withArgument(GeneralServerFlag.CHROME_DRIVER_PORT, Integer.toString(chromePort))
						.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, Integer.toString(bootstrapPort))
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(port).withLogFile(new File("Log" + Thread.currentThread().getName() +
						Thread.currentThread().getId()));
				appiumDriverLocalService = builder.build();
		
		appiumDriverLocalService.start();
		System.out.println("Server has been started");
		//appiumDriverLocalService.getStdOut();	
		System.out.println(appiumDriverLocalService.isRunning());
		System.out.println(builder);
		return builder;
		

	}


	public URL getAppiumUrl() {
		return appiumDriverLocalService.getUrl();
	}

	public void destroyAppiumNode() {
		appiumDriverLocalService.stop();
	}

}
