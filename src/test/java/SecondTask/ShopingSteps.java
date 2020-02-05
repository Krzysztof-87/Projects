package SecondTask;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ShopingSteps {

    WebDriver driver;


    ShopingInfo shopingInfo;

    @Given("^User is logged in to shop$")
    public void userIsLoggedInToShop() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        shopingInfo = new ShopingInfo(driver);
        shopingInfo.loginAs("chris.latacz@gmail.com", "anna13");

    }


    @When("^User choose item$")
    public void userChooseItem() throws StaleElementReferenceException {
        shopingInfo.Item();
    }


    @And("^User choose size and quantity$")
    public void userChooseSizeAndQuantity(DataTable credentials) throws StaleElementReferenceException {
        for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
            shopingInfo.SizeAndQuantity(data.get("size"), data.get("quantity"));

        }


    }

    @And("^User choose checkout option$")
    public void userChooseCheckoutOption()throws StaleElementReferenceException {
        shopingInfo.Checkout();
    }

    @And("^User confirm delivery address$")
    public void userConfirmDeliveryAddress() throws StaleElementReferenceException {
        shopingInfo.Continue();
    }



    @And("^User choose payment method$")
    public void userChoosePaymentMethod() throws StaleElementReferenceException {
        shopingInfo.Payment();
    }

    @And("^User choose obligation to pay$")
    public void userChooseObligationToPay() throws StaleElementReferenceException {
        shopingInfo.Confirmation();
    }

    @And("^System will do screenshot with order Confirmation$")
    public void systemWillDoScreenshotWithOrderConfirmation() throws IOException {


        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/home/krzysztof/Desktop/screen.png"));


    }

    @Then("^Check orders history$")
    public void checkOrdersHistory() throws StaleElementReferenceException{
        shopingInfo.Information();




    }
}