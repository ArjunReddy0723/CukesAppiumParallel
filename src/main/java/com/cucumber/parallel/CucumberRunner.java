package com.cucumber.parallel;

import java.io.File;
import java.io.IOException;

/**
 * Created by saikrisv on 04/03/16.
 */
public class CucumberRunner {

    public void triggerParallelCukes(String feature) throws IOException, InterruptedException {
       /* String a = "java -cp \"" + System.getProperty("user.dir") + "/target/dependency*//*:\""+
                System.getProperty("user.dir") + "/target/classes:" +
                System.getProperty("user.dir") + "/target/test-classes" +
                " cucumber.api.cli.Main " +
                "--glue com.cucumber.steps " +
                System.getProperty("user.dir") + "/src/test/java/com/cucumber/feature/" + feature +
                " --plugin json:" + System.getProperty("user.dir") + "/target/" + feature + ".json";*/

        String a = "java -cp " + getAllJars() +
                System.getProperty("user.dir") + "/target/classes:" +
                System.getProperty("user.dir") + "/target/test-classes" +
                " cucumber.api.cli.Main " +
                "--glue com.cucumber.steps " +
                System.getProperty("user.dir") + "/src/test/java/com/cucumber/feature/" + feature +
                " --plugin json:" + System.getProperty("user.dir") + "/target/" + feature + ".json";
        System.out.println(a);
        Runtime.getRuntime().exec(a);
        Thread.sleep(2000);

    }
    public String getAllJars() {
        File[] files = new File("/Users/saikrisv/git/AppiumTestDistribution/target/dependency/").listFiles();
        StringBuilder str = new StringBuilder(System.getProperty("user.dir")+"/target/dependency/"+files[0].getName()+":");
        for (File file : files) {
            if (file.isFile()) {
                str.append(System.getProperty("user.dir")+"/target/dependency/"+file.getName()+":");
            }

        }
        return str.toString();

    }


}
