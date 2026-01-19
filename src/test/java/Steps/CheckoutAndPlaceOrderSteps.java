package Steps;

import Constants.EndPoints;
import DomainObject.BillingDetailsObject;
import Factory.DriverFactory;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutAndPlaceOrderSteps {

    protected WebDriver driver;
    private WebDriverWait wait;
    protected StorePage storePage;
    protected BillingDetailsObject billingDetails;
    protected CheckoutPage checkout;


    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.load(EndPoints.STORE.url);



    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetailsObject billingDetails) {
        this.billingDetails = billingDetails;


    }
    @And("I have product in the cart")
    public void iHaveProductInTheCart() {
        storePage.addToCart("Blue Denim Shorts");

    }
    @When("I click on Checkout button")
    public void iAmOnTheCheckoutPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();


    }
    @When("I provide billing details")
    public void iProvideBillingDetails() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);

    }
    @And("I place an order")
    public void iPlaceAnOrder() {
       CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.placeOrder();

    }
    @Then("I should see an order confirmation message")
    public void theOrderShouldBePlacedSuccessfully() {
        CheckoutPage checkoutPage  = new CheckoutPage(driver);
        String message = checkoutPage.getConfirmationMessage();
        Assert.assertEquals("Thank you. Your order has been received.",message);
        System.out.println(message);
    }
    @And("an order number should be generated")
    public void anOrderNumberShouldBeGenerated() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String orderNumber = checkoutPage.getOrderNumber();
        Assert.assertTrue(orderNumber.contains("ORDER NUMBER:"));
        System.out.println(orderNumber);


    }






}
