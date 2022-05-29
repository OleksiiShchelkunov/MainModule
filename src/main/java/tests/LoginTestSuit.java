package tests;

import drivers.DriverFactory;
import pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTestSuit {

    @Test
    public void positiveLoginСase() {

        WebDriver driver = DriverFactory.getNewDriver("Chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void negativeLoginCase() {

        WebDriver driver = DriverFactory.getNewDriver("Chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterUsername("incorrect");
        loginPage.enterPassword("incorrect");
        loginPage.clickLoginButton();
        loginPage.checkDisplayOfIncorrectCredentialsError();
        driver.quit();
    }
}