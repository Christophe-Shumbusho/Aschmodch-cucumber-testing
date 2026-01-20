package Steps;

import Constants.EndPoints;
import DomainObject.CustomerLoginDetails;
import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CustomerLoginSteps {
    protected WebDriver driver;
    protected LoginPage login;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver = DriverFactory.getDriver();
        login = new LoginPage(driver);
        login.load(EndPoints.ACCOUNT.url);

    }
    @When("I enter valid credentials")
    public void iEnterValidCredentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        CustomerLoginDetails customer = new CustomerLoginDetails(
                data.get("username"),
                data.get("password")
        );

        login.customerLogin(customer);


    }
    @And("I click on login button")
    public void iClickOnLoginButton(){
        login.clickLoginButton();
    }
    @Then("I should be redirected to my account dashboard")
    public void iShouldBeRedirectedToMyAccountDashboard() {
        System.out.println(login.isDashboardDisplayed());
    }
    @Then("I see a welcome message contains my username")
    public void iSeeAWelcomeMessageContainsMyUsername() {

        String actualWelcomeMessage = login.getWelcomingMessage();
        Assert.assertEquals("Hello Shumbusho (not Shumbusho? Log out)",actualWelcomeMessage);
    }

    @When("I enter invalid password credential")
    public void iEnterInvalidPasswordCredential(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("an error message should be displayed on the login page")
    public void anErrorMessageShouldBeDisplayedOnTheLoginPage() {

    }
}
