package Steps;

import Constants.EndPoints;
import DomainObject.CustomerRegisterDetails;
import Factory.DriverFactory;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CustomerRegistration {
    protected WebDriver driver;
    protected RegistrationPage registration;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        registration = new RegistrationPage(driver);
        registration.load(EndPoints.ACCOUNT.url);

    }
    @When("I enter valid details:")
    public void iEnterValidDetails(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        CustomerRegisterDetails customer = new CustomerRegisterDetails(
                data.get("userName"),
                data.get("email"),
                data.get("password")
        );
        registration.registerCustomer(customer);

    }
    @And("I click on register button")
    public void iClickOnRegisterButton() {

        registration.clickRegisterButton();

    }
    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        System.out.println(registration.isDashboardDisplayed());
    }
    @And("I see welcome message contains my username")
    public void iSeeWelcomeMessageContainsMyUsername() {
        String actualWelcomeMessage = registration.getWelcomeMessage();
        Assert.assertEquals("Hello Christian (not Christian? Log out)",actualWelcomeMessage);
    }

    @When("I enter exist email credential")
    public void iEnterExistEmailCredential(io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("an error message should be displayed on a registration page")
    public void anErrorMessageShouldBeDisplayedOnARegistrationPage() {

    }

    @When("I enter {string} {string} and {string}")
    public void iEnterAnd(String string, String string2, String string3) {

    }
    @Then("an error message {string} should be displayed on the registration page")
    public void anErrorMessageShouldBeDisplayedOnTheRegistrationPage(String string) {

    }


}
