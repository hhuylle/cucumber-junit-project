package com.cydeo.step_definitions;

// In this class we will be able to create "pre" and "post" condition for ALL the scenarios and eve steps

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    // Import the @Before coming from io.cucumber.java
    @Before (order = 1)
    public void setupMethod(){
        System.out.println("--> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After // It will be executed automatically
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        System.out.println("--> @After: RUNNING AFTER EACH SCENARIO");

        //BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("----> @BeforeStep: RUNNING BEFORE EACH STEP");
    }

    //@AfterStep
    public void teardownStep(){
        System.out.println("----> @AfterStep: RUNNING AFTER EACH STEP");
    }
}
