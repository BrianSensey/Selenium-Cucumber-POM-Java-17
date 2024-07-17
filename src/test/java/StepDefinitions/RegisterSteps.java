package StepDefinitions;

import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import PageObjects.LoginPage;
import Utilities.PropertiesReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Map;

public class RegisterSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    RegisterPage register;
    LoginPage login;
    HomePage home;
    AccountPage account;

    public RegisterSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
        register = new RegisterPage(driver, wait);
        login = new LoginPage(driver, wait);
        home = new HomePage(driver, wait);
        account = new AccountPage(driver, wait);
    }

    @Given("El usuario quiere registrarse en el homepage")
    public void registerPage() {
        home.homePageIsDisplayed();
        login.clickRegisterButton();
    }

    @When("El usuario llena los campos personales")
    public void fillPersonalDetails(DataTable dataTable) {
        // Tratamiento de la tabla de datos proveniente del feature
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : list) {
            String firstName = map.get("firstName");
            String lastName = map.get("lastName");
            String address = map.get("address");
            String city = map.get("city");
            String state = map.get("state");
            String zip = map.get("zip");
            String phone = map.get("phone");
            String ssn = map.get("ssn");
            register.fillPersonalDetails(firstName, lastName, address, city, state, zip, phone, ssn);
        }
    }

    @When("El usuario llena los campos de la cuenta e intenta registrarse")
    public void fillAccountDetails(DataTable dataTable) {
        // Tratamiento de la tabla de datos proveniente del feature
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : list) {
            String username = map.get("username");
            String password = map.get("password");
            String confirmPassword = map.get("confirmPassword");
            register.fillAccountDetails(username, password, confirmPassword);
        }
        register.clickSignUpButton();
    }

    @Then("El usuario deberia ver el mensaje {string}")
    public void successSignUp(String happyMessage) {
        Assert.assertEquals(happyMessage,register.happyMessageIsDisplayed());
    }

    @Then("El nuevo usuario deberia poder loguearse")
    public void successLogin(DataTable dataTable) {
        account.clickLogOutButton();
        // Tratamiento de la tabla de datos proveniente del feature
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> map : list) {
            String username = map.get("username");
            String password = map.get("password");
            login.fillLoginDetails(username, password);
        }
        login.clickLoginButton();
        account.accountOverviewIsDisplayed();
    }
}