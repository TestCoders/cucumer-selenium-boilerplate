package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Homepage;
import pageobjects.Searchresults;
import utils.FileUtils;
import utils.Waits;

import java.io.File;
import java.io.IOException;

public class StepDefinitions {

    private WebDriver driver;

    public void startDriver(String url){

        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            FileUtils fileUtils = new FileUtils();
            fileUtils.addScreenshot(scenario, driver);
        }

        driver.quit();

    }

    @Given("the site DuckDuckGo is open")
    public void theSiteDuckDuckGoIsOpen() {

        startDriver("https://duckduckgo.com/");

        Waits waits = new Waits(driver);
        Homepage homepage = new Homepage(driver);
        waits.waitForElement(homepage.logoHomepage);

    }

    @Then("the searchbar is enabled")
    public void theSearchbarIsEnabled() {

        Waits waits = new Waits(driver);
        Homepage homepage = new Homepage(driver);

        waits.waitForElement(homepage.searchBar);
        Assert.assertTrue(homepage.searchBar.isEnabled());

    }

    @When("I search for {string}")
    public void iSearchFor(String searchObject) {

        Homepage homepage = new Homepage(driver);
        homepage.searchBar.sendKeys(searchObject);
        homepage.searchButton.click();

    }

    @Then("I can see the search results for {string}")
    public void iCanSeeTheSearchResultsFor(String searchObject) {

        Waits waits = new Waits(driver);
        Searchresults searchresults = new Searchresults(driver);

        waits.waitForElement(searchresults.sidebarTitle);
        Assert.assertEquals(searchObject, searchresults.sidebarTitle.getText().toLowerCase());

    }
}
