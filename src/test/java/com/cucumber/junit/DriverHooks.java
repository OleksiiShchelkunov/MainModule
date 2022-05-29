package com.cucumber.junit;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class DriverHooks {

    private WebDriver driver;

    @Before
    public void launchDriver () {
        driver = DriverFactory.getNewDriver("Chrome");
    }

    @After
    public void closeDriver () {
        driver.close();
        driver.quit();
    }
}
