package com.cucumber;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by saikrisv on 04/03/16.
 */
public class CucumberRunner {

    CommandPrompt cmd = new CommandPrompt();

    @Test
    public void testApp() throws IOException, InterruptedException {

       String a =  "java -cp "+ System.getProperty("user.dir")+"/libs/cucumber-core-1.2.4.jar:"+
                System.getProperty("user.dir")+"/libs/gherkin-2.12.2.jar:"+
                System.getProperty("user.dir")+"/libs/cucumber-html-0.2.3.jar:"+
                System.getProperty("user.dir")+"/libs/cucumber-java-1.2.4.jar:"+
                System.getProperty("user.dir")+"/libs/cucumber-jvm-deps-1.0.5.jar:" +
                System.getProperty("user.dir")+"/target/classes:"+
                System.getProperty("user.dir")+"/target/test-classes"+
                " cucumber.api.cli.Main " +
                "--glue com.cucumber.steps " +
                System.getProperty("user.dir")+"/src/main/resources/com/cucumber/Sample.feature "
                + " --plugin json:"+System.getProperty("user.dir")+"/target/sample.feature.json";
         Runtime.getRuntime().exec(a);

    }
}
