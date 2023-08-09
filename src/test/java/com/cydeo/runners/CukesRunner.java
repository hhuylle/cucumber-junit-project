package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = { // to determine type of reports, and store them into where we want to store my report files
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions", //
        dryRun = false, // generating snippet, if turn on like true it will not execute the actual code, otherwise it will execute. Glue is taking path of step definitions
        tags = "@vytrackDashboard", // creating different scenarios suite which ones run or not
        publish = true // generating a report with public link
)
public class CukesRunner {} // to run the tests, and generate codes for step definitions

/*
What are the advantages of Cucumber?
Cucumber acceptance tests are written from the user’s perspective

Tests are written in plain-text English so people with less technical skills can also write scenarios

Team Collaboration (Product owners, business analysts, developers, testers are all involved in writing scenarios)
 */