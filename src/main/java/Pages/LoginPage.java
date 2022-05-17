package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CorePage {

    @FindBy(css = ".login_logo")
    WebElement pageLogo;

    @FindBy(css = "#user-name")
    WebElement usernameField;

    @FindBy (css = "#password")
    WebElement passwordField;

    @FindBy (css = "#login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container > h3")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage () {
        getDriver().navigate().to("https://www.saucedemo.com/");
    }

    public void enterUsername (String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton () {
        loginButton.click();
    }

    public void checkDisplayOfIncorrectCredentialsError () {
        errorMessage.isDisplayed();
    }

}
