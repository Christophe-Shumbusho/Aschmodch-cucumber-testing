package Factory;

import Utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initializeDriver(String browser){
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("INVALID BROWSER" + browser);

        }
        driver.manage().window().maximize();
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
