package com.cucumber.parallel;

import com.appium.manager.ParallelThread;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by saikrisv on 09/03/16.
 */
public class CucumberParallelThread {

    public CucumberRunner cucumberRunner = new CucumberRunner();
    public HtmlReporter htmlReporter = new HtmlReporter();
    public static  List<String> featureFiles= new ArrayList<String>();



    public void distributeTests(int deviceCount, List<String> feature) {
        listFilesForFolder(new File("/Users/saikrisv/git/untitled/src/test/java/com/cucumber/feature/"));
        ExecutorService executorService = Executors.newFixedThreadPool(deviceCount);
        for (final String featureFile : feature) {
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println("Running test file: " + featureFile + Thread.currentThread().getId());
                    try {
                        cucumberRunner.triggerParallelCukes(featureFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ending");
        try {
            Thread.sleep(3000);
            htmlReporter.generateReports();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else if (fileEntry.getName().endsWith(".feature")) {
                featureFiles.add(fileEntry.getName());

            }
        }
    }


    public static void main(String[] arg) throws Exception {
        ParallelThread parallelThread = new ParallelThread();
        parallelThread.runner("com.cucumber.parallel");
        CucumberParallelThread cucumberParallelThread = new CucumberParallelThread();

        cucumberParallelThread.distributeTests(2,featureFiles);
    }
}
