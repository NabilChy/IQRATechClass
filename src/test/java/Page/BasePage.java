package Page;


import com.qa.factory.BrowserFactory;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static WebDriver driver = null;

    public WebDriver getDriver(){
        driver = BrowserFactory.getDriver();
        return driver;
    }

    public void navigateURL(){
        //getDriver();
        driver.get("https://qa.iqrashoppingdemo.xyz/"); // update url and xpath for username and password and login
    }

    public WebElement getElement(String locator){
        WebDriverWait w1 = new WebDriverWait(driver, 10);
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        WebElement ele = driver.findElement(By.xpath(locator));

        return ele;
    }
}
