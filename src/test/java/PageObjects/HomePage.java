package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    @CacheLookup
    private WebElement userNameInput;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button']")
    @CacheLookup
    private WebElement loginButton;

    public boolean homePageIsDisplayed() {
        WaitUntilElementVisible(userNameInput);
        userNameInput.isDisplayed();
        WaitUntilElementVisible(passwordInput);
        passwordInput.isDisplayed();
        WaitUntilElementVisible(loginButton);
        loginButton.isDisplayed();
        return true;
    }
}