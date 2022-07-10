package tests;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pageClasses.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import сore.appconfig.Config;

@SpringJUnitConfig(Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginTestSuit {

    @Autowired
    public LoginPage loginPage;

    @Test
    public void positiveLoginCase() {
        WebDriver driver = loginPage.getDriver();
        loginPage.openLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();
    }

    @Test
    public void negativeLoginCase() {
        WebDriver driver = loginPage.getDriver();
        loginPage.openLoginPage();
        loginPage.enterUsername("incorrect");
        loginPage.enterPassword("incorrect");
        loginPage.clickLoginButton();
        loginPage.checkDisplayOfIncorrectCredentialsError();
        driver.quit();
    }
}