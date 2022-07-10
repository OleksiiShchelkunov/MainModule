package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import pages.CorePage;

@Component("loginPage")
public class LoginPage extends CorePage {

    private final static String LOGIN_URL = "https://www.saucedemo.com/";

    @FindBy(css = ".login_logo")
    WebElement pageLogo;

    @FindBy(css = ".bot_column")
    WebElement titleImage;

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
        getDriver().navigate().to(LOGIN_URL);
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

    public void checkDisplayOfPageLogo () {
        pageLogo.isDisplayed();
    }

    public void checkDisplayOfTitleImage () {
        titleImage.isDisplayed();
    }
}
