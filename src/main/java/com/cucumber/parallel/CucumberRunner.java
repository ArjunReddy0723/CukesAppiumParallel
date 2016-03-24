package com.cucumber.parallel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                System.getProperty("user.dir") + "/src/test/java/com/cucumber/features/" + features +
                " --plugin json:" + System.getProperty("user.dir") + "/target/" + features + ".json";*/
        String compileClasses = System.getProperty("user.dir") + "/target/classes:";
        String compileTestClasses = System.getProperty("user.dir") + "/target/test-classes";
        String classpPath = System.getProperty("user.dir") + "/target/dependency/*:";

        String a ="java -cp \"" + System.getProperty("user.dir") + "/target/dependency/*:\""+
                System.getProperty("user.dir") + "/target/classes:" +
                System.getProperty("user.dir") + "/target/test-classes" +
                " cucumber.api.cli.Main " +
                "--glue com.cucumber.steps " +
                System.getProperty("user.dir") + "/src/test/java/com/cucumber/features/" + feature +
                " --plugin json:" + System.getProperty("user.dir") + "/target/" + feature + ".json";
        System.out.println(a);
        runCommandThruProcessBuilder(a);
        Thread.sleep(2000);

    }

    public String getAllJars() {
        File[] files = new File("/Users/saikrisv/git/AppiumTestDistribution/target/dependency/").listFiles();
        StringBuilder str = new StringBuilder(System.getProperty("user.dir") + "/target/dependency/" + files[0].getName() + ":");
        for (File file : files) {
            if (file.isFile()) {
                str.append(System.getProperty("user.dir") + "/target/dependency/" + file.getName() + ":");
            }

        }
        return str.toString();

    }

    public void runCommandThruProcessBuilder(String command) throws InterruptedException, IOException {
        List<String> commands = new ArrayList<String>();
        commands.add("/bin/sh");
        commands.add("-c");
        commands.add(command);
        ProcessBuilder builder = new ProcessBuilder(commands);
        Map<String, String> environ = builder.environment();
        final Process process = builder.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        String allLine = "";
        while ((line = br.readLine()) != null) {
            allLine = allLine + "" + line + "\n";
            System.out.println(allLine);
        }


    }
}
