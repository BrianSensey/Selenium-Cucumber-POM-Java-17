package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BaseClass {

    public AccountPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Log Out']")
    @CacheLookup
    private WebElement logOutButton;

    @FindBy(xpath = "//h1[@class='title' and contains(text(),'Accounts Overview')]")
    @CacheLookup
    private WebElement accountOverviewTitle;

    public  void clickLogOutButton() {
        WaitUntilElementVisible(logOutButton);
        logOutButton.isEnabled();
        logOutButton.click();
    }

    public boolean accountOverviewIsDisplayed() {
        WaitUntilElementVisible(accountOverviewTitle);
        accountOverviewTitle.isDisplayed();
        return true;
    }
}