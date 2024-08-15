package stepDefinations;

import Page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDef {
    LoginPage lp;

    public LoginStepDef(){
        lp = new LoginPage();
    }

    @Given("navigate to the application")
    public void navigateToURL(){

        lp.navigateToLoginPage();
    }

    @When("I enter valid username and valid password")
    public void iEnterValidUsernameAndValidPassword(List<Map<String, String>> userDataMapList){
        Map<String, String> dataMap = userDataMapList.get(0);
        lp.login(dataMap.get("username"),dataMap.get("password"));
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        lp.click_Enter();
    }

    @Then("I am able to verify the homepage with {string}")
    public void iAmAbleToVerifyTheHomepage(String username) {

        Boolean flag = lp.validateHomepage(username);
        Assert.assertTrue(flag,"Homepage not validated");
    }

    @When("I enter valid username and invalid password")
    public void iEnterValidUsernameAndInvalidPassword() throws InterruptedException {
        lp.login("FirstTry","Y2vcSSqi3");
    }

    @Then("I am unable to verify the homepage")
    public void iAmUnableToVerifyTheHomepage() {
        
    }

    @When("I enter invalid username and valid password")
    public void iEnterInvalidUsernameAndValidPassword() throws InterruptedException {
        lp.login("FTry","Y2vKQgDzdcSSqi3");
    }

    @When("I enter invalid username and invalid password")
    public void iEnterInvalidUsernameAndInvalidPassword() throws InterruptedException {
        lp.login("FTry","Y2vcSSqi3");
    }

    @When("I enter valid {string} and valid {string} from testData table")
    public void iEnterValidAndValidFromTestDataTable(String username, String password) {
        lp.login(username, password);
    }

}
