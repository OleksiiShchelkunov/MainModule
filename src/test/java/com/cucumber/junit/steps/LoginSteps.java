package com.cucumber.junit.steps;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageClasses.LoginPage;

public class LoginSteps {

    WebDriver driver = DriverFactory.getNewDriver("Chrome");
    LoginPage loginPage = new LoginPage(driver);

    @Given("open the Login page")
    public void openLoginPage () {
        loginPage.openLoginPage();
    }

    @When("user enters {string} to Username field")
    public void entersValueToUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters {string} to Password field")
    public void entersValueToPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("current url corresponds to {string}")
    public void pageIsDisplayed(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Logo is displayed")
    public void logoIsDisplayed() {
        loginPage.checkDisplayOfPageLogo();
    }

    @Then("Title image is displayed")
    public void titleImageisDisplayed() {
        loginPage.checkDisplayOfTitleImage();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        loginPage.checkDisplayOfIncorrectCredentialsError();
    }
}
