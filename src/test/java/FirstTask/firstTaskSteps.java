package FirstTask;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void loggedUserGoesToAddress() {
        firsttaskInfo.goToAccountDetail();

    }

    @And("^User add \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5)  {
        firsttaskInfo.setAdress(arg0,arg1,arg2,arg3,arg4,arg5);
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^User saves all information and can see message \"([^\"]*)\"\\.$")
    public void userSavesAllInformationAndCanSeeMessage( String message)  {
        firsttaskInfo.submitAddress();
        Assert.assertEquals(message, firsttaskInfo.getUpdateInformation());
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^Logged user deleted address and can see \"([^\"]*)\"$")
    public void loggedUserDeletedAddressAndCanSee(String message)  {
        firsttaskInfo.deleteAddress();
        Assert.assertEquals(message, firsttaskInfo.getUpdateInformation());
        driver.quit();
        // Write code here that turns the phrase above into concrete actions

    }
}