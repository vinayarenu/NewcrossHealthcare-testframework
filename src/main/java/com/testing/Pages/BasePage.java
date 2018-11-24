package com.testing.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    //Create Constructor
    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    //Getting currentUrl
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    //Getting title
    public String getTitle() {
        return driver.getTitle();
    }

    //maximise browser
    public void maximiseBrowser() {

        driver.manage().window().maximize();
    }
    //implicit wait
    public void applyImplicitWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
