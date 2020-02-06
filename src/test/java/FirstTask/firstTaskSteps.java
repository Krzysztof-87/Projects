package FirstTask;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class firstTaskSteps {

    WebDriver driver;
    FirsttaskInfo firsttaskInfo;


    @Given("^User is logged in to the shop$")
    public void userIsLoggedInToTheShop() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        firsttaskInfo = new FirsttaskInfo(driver);
        firsttaskInfo.loginAs("chris.latacz@gmail.com", "anna13");
        firsttaskInfo = new FirsttaskInfo(driver);

    }

    @When("^Logged user goes to address$")
    public void loggedUserGoesToAddress() throws InterruptedException {
        Thread.sleep(1500);
        firsttaskInfo.goToAccountDetail();
        Thread.sleep(1500);

    }

    @And("^User add \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddAndAndAndAndAnd(String alias, String address, String city, String postcode, String country, String phone)  {
        firsttaskInfo.setAdress(alias,address,city,postcode, country,phone);


    }

    @And("^User saves all information$")
    public void userSavesAllInformation( ) throws InterruptedException  {
        Thread.sleep(1500);
        firsttaskInfo.submitAddress();
        Thread.sleep(1500);


    }
    @And("^and can see message \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void andCanSeeMessageAndAndAndAndAnd(String alias, String address, String city, String postcode, String country, String phone) {

        String lastAlias = firsttaskInfo.compareAliasToAlias();
        String lastAddress = firsttaskInfo.CompareAddresses();
        System.out.println(lastAlias);
        System.out.println(lastAddress);
        Assert.assertTrue(lastAlias.contains(alias));
        Assert.assertTrue(lastAddress.contains(address));
        Assert.assertTrue(lastAddress.contains(city));
        Assert.assertTrue(lastAddress.contains(postcode));
        Assert.assertTrue(lastAddress.contains(country));
        Assert.assertTrue(lastAddress.contains(phone));

    }


    @Then("^Logged user deleted address and can see \"([^\"]*)\"$")
    public void loggedUserDeletedAddressAndCanSee(String arg0) {
        firsttaskInfo.deleteAddress();
        driver.quit();

    }



}
