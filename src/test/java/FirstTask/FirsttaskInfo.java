package FirstTask;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirsttaskInfo {

    private static WebDriver driver;

    public FirsttaskInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "account")
    WebElement account;

    @FindBy(css = "a[href*=addresses] i")
    WebElement addresses;

    @FindBy(css = "a[data-link-action=add-address]")
    WebElement newAddress;

    @FindBy(name ="alias")
    WebElement aliasInput;

    @FindBy(name ="address1" )
    WebElement addressInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement zipInput;

    @FindBy(name ="id_country")
    WebElement countryInput;

    @FindBy(name="phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary")
    WebElement saveButton;

    @FindBy(css = " .alert.alert-success")
    WebElement successInformation;

    @FindBy(css = "a[href*=delete] i")
    WebElement delete;

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

    public void goToAccountDetail() {
        account.click();
        addresses.click();
        newAddress.click();
    }

    public void setAdress(String alias, String address, String city, String postcode, String country, String phone) {
        aliasInput.click();
        aliasInput.sendKeys(alias);
        addressInput.click();
        addressInput.sendKeys(address);
        cityInput.click();
        cityInput.sendKeys(city);
        zipInput.click();
        zipInput.sendKeys(postcode);
        countryInput.click();
        countryInput.sendKeys(country);
        phoneInput.click();
        phoneInput.sendKeys(phone);
    }

    public void submitAddress(){
        saveButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

    public void deleteAddress(){
        delete.click();
    }









}
