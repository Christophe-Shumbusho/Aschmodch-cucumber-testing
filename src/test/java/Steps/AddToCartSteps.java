package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

    @Given("I am on the store page")
    public void iAmOnTheStorePage() {

    }
    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String string) {

    }
    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(Integer int1, String string) {

    }

    @When("I add a \"\"Blue Shoes\"\" to the cart")
    public void iAddABlueShoesToTheCart() {

    }
    @Then("I should see \"\"Blue Shoes\"\" in the cart")
    public void iShouldSeeBlueShoesInTheCart() {

    }

    @When("I add a \"\"Black Over-the-shoulder Handbag\"\" to the cart")
    public void iAddABlackOverTheShoulderHandbagToTheCart() {

    }
    @Then("I should see \"\"Black Over-the-shoulder Handbag\"\" in the cart")
    public void iShouldSeeBlackOverTheShoulderHandbagInTheCart() {

    }


}
