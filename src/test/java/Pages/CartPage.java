package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    @FindBy(css = "td[class='product-name'] a") private WebElement productNames;
    @FindBy(css = "input[type ='number']") private WebElement productQuantityField;
    @FindBy(css = ".checkout-button") private WebElement checkoutButton;
    public CartPage(WebDriver driver) {
        super(driver);
    }

   public String getProductNames(){
        wait.until(ExpectedConditions.visibilityOf(productNames));
        return productNames.getText();
   }
   public int getProductQuantity(){
        wait.until(ExpectedConditions.visibilityOf(productQuantityField));
        return Integer.parseInt(productQuantityField.getAttribute("value"));
   }
   public CheckoutPage clickCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage(driver);
   }
   public boolean isCheckoutButtonDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        return checkoutButton.isDisplayed();
   }
}
