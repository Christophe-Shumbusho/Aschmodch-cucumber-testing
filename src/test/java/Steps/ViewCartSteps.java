package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCartSteps {
    @Given("I have items in the cart")
    public void iHaveItemsInTheCart(io.cucumber.datatable.DataTable dataTable) {

    }
    @When("I view the cart")
    public void iViewTheCart() {

    }
    @Then("the cart should list all added products")
    public void theCartShouldListAllAddedProducts() {

    }

    @Given("I have no items in the cart")
    public void iHaveNoItemsInTheCart() {

    }

    @Then("the cart should display {string}")
    public void theCartShouldDisplay(String string) {

    }
}
