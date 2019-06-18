package com.parkingcalculatortest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Adelquis Trinidad
 */
public class DriverFactory {
    private  static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory() {
        //prevent instantiation
    }

    /**
     *
     * @return driver Returns an instance of chrome
     */
    public static WebDriver getChromeDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return  driver;
    }

    /**
     *
     * @return wait Return the implicit wait for chrome
     */
    public static WebDriverWait getWebDriverWait() {
        if(wait == null) {
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }
}
