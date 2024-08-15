package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SynchroWait {
    WebDriver driver;
    public void ImplicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void ExpliWait(){
        WebDriverWait w1 = new WebDriverWait(driver, 10);
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }

    public void FluWait(){
        Wait w2 = new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        w2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("password")));

    }
}
