package SecondTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingInfo {

    private static WebDriver driver;


    public ShopingInfo(WebDriver driver) {
        ShopingInfo.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name ="s")
    WebElement itemInput;

    @FindBy(xpath = "//span[@class='product']")
    WebElement itemChoose;

    @FindBy(name ="group[1]")
    WebElement sizeChoose;

    @FindBy(name ="qty")
    WebElement quantityChoose;

    @FindBy(xpath="//div[@class='add']/button")
    WebElement SubmitButton;


    @FindBy(xpath= "//div[@class='cart-content-btn']/a")
    WebElement goToCheckout;


    @FindBy(css = ".btn.btn-primary")
    WebElement Checkout;

    @FindBy(css = ".btn.btn-primary")
    WebElement confirm;

    @FindBy(name ="confirmDeliveryOption")
    WebElement Delivery;

    @FindBy(id ="payment-option-1")
    WebElement paymenetOption;

    @FindBy(name ="conditions_to_approve[terms-and-conditions]")
    WebElement terms;

    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement obligationToPay;

    @FindBy(className = "account")
    WebElement userInfo;

    @FindBy(id = "history-link")
    WebElement history;



    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }


    public void Item(){
        itemInput.click();
        itemInput.sendKeys("Hummingbird Printed Sweater");
        itemInput.click();
        itemChoose.click();

    }

    public void SizeAndQuantity(String size, String quantity) {
        sizeChoose.click();
        sizeChoose.sendKeys(size);
        quantityChoose.clear();
        quantityChoose.sendKeys(quantity);
        SubmitButton.click();

    }



    public void Checkout(){
        goToCheckout.click();
        Checkout.click();

    }

    public void Continue(){
        confirm.click();
        Delivery.click();
    }


    public void Payment(){
        paymenetOption.click();
    }

    public void Confirmation(){
        terms.click();
        obligationToPay.click();
    }


    public void Information(){
        userInfo.click();
        history.click();

    }


}
