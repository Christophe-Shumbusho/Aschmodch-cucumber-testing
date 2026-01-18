package Pages;

import DomainObject.CustomerRegisterDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(id = "reg_username") private WebElement userNameField;
    @FindBy(id = "reg_email") private WebElement userEmailField;
    @FindBy(id = "reg_password") private WebElement userPasswordField;
    @FindBy(css = "button[value='Register']") private WebElement registerButton;
    @FindBy(css = "div[id='content'] li:nth-child(1)") private WebElement errorMessage;
    @FindBy(linkText = "Dashboard") private WebElement dashboardLink;
    @FindBy(css = "div.woocommerce-MyAccount-content p") private WebElement welcomeMessage;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    public void registerCustomer(CustomerRegisterDetails customer){
        userNameField.sendKeys(customer.getUserName());
        userEmailField.sendKeys(customer.getUserEmail());
        userPasswordField.sendKeys(customer.getUserPassword());
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public boolean isDashboardDisplayed(){
        return dashboardLink.isDisplayed();
    }

    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }




}
