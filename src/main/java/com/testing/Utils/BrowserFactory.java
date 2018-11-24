package com.testing.Utils;

import com.testing.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory extends BasePage {
    public static void startBrowser() {


        if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinay\\Downloads\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver( );
        } else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinay\\Downloads\\drivers\\chromedriver.exe");
            driver = new ChromeDriver( );
        } else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\vinay\\Downloads\\drivers\\MicrosoftWebDriver.exe");
        }

        driver.get(AutomationConstants.baseURL);
        driver.manage( ).timeouts( ).pageLoadTimeout(AutomationConstants.TIMEOUT, TimeUnit.SECONDS);
    }

    public void stopBrowser() {
        if (driver != null) {
            driver.quit( );
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {

            BrowserFactory.startBrowser( );
        }
        return driver;
    }


}
