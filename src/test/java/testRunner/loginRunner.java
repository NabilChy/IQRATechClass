package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\daiya\\IdeaProjects\\CucumberDemo\\src\\test\\resources\\features"},glue = {"stepDefinations","Hooks"},
        plugin = {"pretty","html:target/cucumber-reports","junit:target/cc-report/Cucumber.xml",
                "json:target/cc-report/Cucumber.json"},monochrome = false)

public class loginRunner {

}
