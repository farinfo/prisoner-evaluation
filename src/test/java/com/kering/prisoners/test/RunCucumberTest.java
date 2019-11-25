package com.kering.prisoners.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(features="src/test/features", tags = {"~@Ignore"}, glue = "com.kering.prisoners.test",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cucumber.xml"})
public class RunCucumberTest {

}
