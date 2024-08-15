package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public WebDriver driver = null;
    //String usr = "FirstTry";
    //String email = "thisisfirsttry@gmail.com";
    //String pwd = "Y2vKQgDzdcSSqi3";
    public LoginPage(){
        this.driver = getDriver();
    }
    public void navigateToLoginPage(){
        navigateURL();
        System.out.println("This is LoginPage.java");
    }

    public void login(String usr, String pwd){

        WebElement login_usr = driver.findElement(By.xpath("//input[@id='username']"));
        login_usr.click();
        login_usr.sendKeys(usr);


        WebElement login_pwd = driver.findElement(By.id("password"));
        login_pwd.click();
        login_pwd.sendKeys(pwd);

    }

    public void click_Enter(){
        WebElement login_button = driver.findElement(By.name("login"));
        login_button.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Dashboard']")));
    }

    public Boolean validateHomepage(String username){
        Boolean flag = false;
        WebElement validation = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']//p"));
        String validd = validation.getText().trim();
        if(validd.contains("Hello " +username)){
            System.out.println("Home page validated");
            flag = true;
        }
        return flag;
    }


}
