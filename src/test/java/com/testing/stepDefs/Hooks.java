package com.testing.stepDefs;

import com.testing.Pages.BasePage;
import com.testing.Utils.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BasePage {

    @Before
    public void setUp(){
        BrowserFactory.startBrowser();
        maximiseBrowser();
        applyImplicitWait();
    }

    @After
    public void cleanUp(){
        //driver.quit();
    }
}

