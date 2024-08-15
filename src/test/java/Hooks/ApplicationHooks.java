package Hooks;

import Page.BasePage;
import com.qa.factory.BrowserFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Properties;

public class ApplicationHooks{

    private BrowserFactory browserFactory;
    private WebDriver driver;

    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.initProp();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName =  prop.getProperty("browser");
        browserFactory = new BrowserFactory();
        driver  = browserFactory.init_Driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @AfterStep(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }


}
