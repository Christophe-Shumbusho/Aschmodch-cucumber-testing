package Pages;

import DomainObject.BillingDetailsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    @FindBy(id = "billing_first_name") private WebElement billingFirstNameField;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameField;
    @FindBy(id = "select2-billing_country-container") private WebElement billingCountryField;
    @FindBy(id = "billing_email") private WebElement billingEmailField;
    @FindBy(id = "billing_address_1") private WebElement billingAddressField;
    @FindBy(id = "billing_city") private WebElement billingCityField;
    @FindBy(id = "billing_state")private WebElement billingStateField;
    @FindBy(id = "billing_postcode") private WebElement billingZipField;
    @FindBy(id = "place_order") private WebElement placeOrderButton;
    @FindBy(css = ".woocommerce-notice") private WebElement confirmationMessage;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    @FindBy(css = ".woocommerce-order-overview__order.order") private WebElement orderNumber;
    @FindBy(css = ".woocommerce-error li") private WebElement errorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameField));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameField));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage selectBillingCountry(String billingCountryName){
        wait.until(ExpectedConditions.elementToBeClickable(billingCountryField)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingCountryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }


    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressField));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityField));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipField));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailField));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetailsObject billingDetails){
            return enterBillingFirstName(billingDetails.getBillingFirstName()).
                    enterBillingLastName(billingDetails.getBillingLastName()).
                    selectBillingCountry(billingDetails.getBillingCountry()).
                    enterBillingAddressLineOne(billingDetails.getBillingAddress()).
                    enterBillingCity(billingDetails.getBillingCity()).
                    enterBillingZip(billingDetails.getBillingZip()).
                    enterBillingEmail(billingDetails.getBillingEmail());

    }

    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        return this;
    }

    public String getConfirmationMessage(){
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }

    public String getOrderNumber(){
        wait.until(ExpectedConditions.visibilityOf(orderNumber));
        return orderNumber.getText();
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }




}
