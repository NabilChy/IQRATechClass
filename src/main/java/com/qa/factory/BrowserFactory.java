package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static ThreadLocal<WebDriver> tlDrivers = new ThreadLocal<>();
    public WebDriver driver;
    //Factory method for getting browsers
    public WebDriver init_Driver(String browserName) {
        System.out.println("browser value is : " + browserName);

        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().create();
            tlDrivers.set(new ChromeDriver());
        }

        if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().create();
            tlDrivers.set(new FirefoxDriver());
        }

        if(browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().create();
            tlDrivers.set(new EdgeDriver());
        }

        else if(browserName.equals("safari")) {
            tlDrivers.set(new SafariDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

       return getDriver();
    }

    public static synchronized WebDriver getDriver(){

        return tlDrivers.get();
    }



}
