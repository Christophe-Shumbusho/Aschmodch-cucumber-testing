package Steps;

import Constants.EndPoints;
import DomainObject.ProductObject;
import Factory.DriverFactory;
import Pages.CartPage;
import Pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps {
    protected WebDriver driver;
    protected StorePage storePage;
    private CartPage cartPage;
    @Given("I am on the store page")
    public void iAmOnTheStorePage() {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.load(EndPoints.STORE.url);

    }
    @When("I add a {product} to the cart")
    public void iAddABlueShoesToTheCart(ProductObject product) {
        storePage.addToCart(product.getProduct());

    }
    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeBlueShoesInTheCart(int quantity,ProductObject product) {

        CartPage cartPage = new CartPage(driver);
        String names = cartPage.getProductNames();
        Assert.assertEquals(product.getProduct(),names);
        Assert.assertEquals(quantity,cartPage.getProductQuantity());



    }

}
