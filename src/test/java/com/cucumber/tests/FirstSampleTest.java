package com.cucumber.tests;

import com.cucumber.parallel.CucumberRunner;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by saikrisv on 09/03/16.
 */
public class FirstSampleTest {

    CucumberRunner cucumberRunner = new CucumberRunner();

    @Test
    public void testCukes() throws IOException, InterruptedException {
        cucumberRunner.triggerParallelCukes();
    }
}
