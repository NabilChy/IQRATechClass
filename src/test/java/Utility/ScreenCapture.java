package Utility;

import Page.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenCapture{
    public void EventFiringSCR(WebDriver driver) throws IOException {
        EventFiringWebDriver scr1 = new EventFiringWebDriver(driver);
        File fs = scr1.getScreenshotAs(OutputType.FILE);
        File fs1 = new File("C:\\Users\\daiya\\IdeaProjects\\CucumberDemo\\src\\test\\resources\\Snapshot\\scr1.jpg");
        FileUtils.copyFile(fs,fs1);
    }

    public void TakeSCR(WebDriver driver) throws IOException {
        TakesScreenshot scr2 = (TakesScreenshot) driver;
        File fs2 = scr2.getScreenshotAs(OutputType.FILE);
        File fs3 = new File("C:\\Users\\daiya\\IdeaProjects\\CucumberDemo\\src\\test\\resources\\Snapshot\\scr2.jpg");
        FileUtils.copyFile(fs2,fs3);
    }
}
