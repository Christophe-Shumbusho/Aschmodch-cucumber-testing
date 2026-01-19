package Factory;

import Utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initializeDriver(String browser){
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
