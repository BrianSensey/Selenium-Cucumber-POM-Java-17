package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='login']//input[@type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    @CacheLookup
    private WebElement registerButton;

    public  void fillUsername(String username) {
        WaitUntilElementVisible(usernameField);
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public  void fillPassword(String password) {
        WaitUntilElementVisible(passwordField);
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUntilElementVisible(loginButton);
        loginButton.isEnabled();
        loginButton.click();
    }

    public  void clickRegisterButton() {
        WaitUntilElementVisible(registerButton);
        registerButton.isEnabled();
        registerButton.click();
    }

    public void fillLoginDetails(String username, String password) {
        fillUsername(username);
        fillPassword(password);
    }
}