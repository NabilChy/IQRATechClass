package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features={"C:\\Users\\daiya\\IdeaProjects\\CucumberDemo\\src\\test\\resources\\features"}, glue={"stepDefinations", "Hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/"})

public class extentRunner {

}
