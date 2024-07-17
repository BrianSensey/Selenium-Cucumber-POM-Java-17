package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BaseClass {

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer.firstName")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    @CacheLookup
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    @CacheLookup
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    @CacheLookup
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    @CacheLookup
    private WebElement zipField;

    @FindBy(id = "customer.phoneNumber")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    @CacheLookup
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    @CacheLookup
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//table//input[@type='submit']")
    @CacheLookup
    private WebElement signUpButton;

    @FindBy(xpath = "//h1[@class='title']/following-sibling::p")
    @CacheLookup
    private WebElement happyMessageLabel;

    public void fillFirstName(String firstName) {
        WaitUntilElementVisible(firstNameField);
        firstNameField.isEnabled();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WaitUntilElementVisible(lastNameField);
        lastNameField.isEnabled();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void fillAddress(String address) {
        WaitUntilElementVisible(addressField);
        addressField.isEnabled();
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void fillCity(String city) {
        WaitUntilElementVisible(cityField);
        cityField.isEnabled();
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void fillState(String state) {
        WaitUntilElementVisible(stateField);
        stateField.isEnabled();
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void fillZip(String zip) {
        WaitUntilElementVisible(zipField);
        zipField.isEnabled();
        zipField.clear();
        zipField.sendKeys(zip);
    }

    public void fillPhone(String phone) {
        WaitUntilElementVisible(phoneField);
        phoneField.isEnabled();
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void fillSSN(String ssn) {
        WaitUntilElementVisible(ssnField);
        ssnField.isEnabled();
        ssnField.clear();
        ssnField.sendKeys(ssn);
    }

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

    public  void fillConfirmPassword(String confirmPassword) {
        WaitUntilElementVisible(confirmPasswordField);
        confirmPasswordField.isEnabled();
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickSignUpButton() {
        WaitUntilElementVisible(signUpButton);
        signUpButton.isEnabled();
        signUpButton.click();
    }

    public String happyMessageIsDisplayed() {;
        WaitUntilElementVisible(happyMessageLabel);
        String happyMessage = happyMessageLabel.getText();
        return happyMessage;
    }

    public void fillPersonalDetails(String firstName, String lastName, String address, String city, String state, String zip, String phone, String ssn) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        fillCity(city);
        fillState(state);
        fillZip(zip);
        fillPhone(phone);
        fillSSN(ssn);
    }

    public void fillAccountDetails(String username, String password, String confirmPassword) {
        fillUsername(username);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
    }

}