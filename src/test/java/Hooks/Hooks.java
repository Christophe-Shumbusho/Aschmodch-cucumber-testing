package Hooks;

import Factory.DriverFactory;
import Pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

 protected WebDriver driver;

     @Before
    public void setUp(){
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
    }
    @After
    public void tearDown(){
        if(DriverFactory.getDriver() != null){
            DriverFactory.getDriver().quit();
        }

    }

}
