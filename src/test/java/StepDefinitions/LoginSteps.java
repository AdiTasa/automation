package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.loginPage;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class LoginSteps extends Setup {
    WebDriver driver = null;
    String baseUrl = null;
    loginPage lp = null;


    @Before
    public void beforeScenario() {

        try {
            driver = get_webdriver();
            lp = new loginPage(driver);
            baseUrl = get_baseUrl();
        } catch (NullPointerException e) {
            System.out.println("ERROR: "+e);
            assertNull(driver);
        }

    }

    @Given("user goes to the login page")
    public void login_page() throws InterruptedException {
        driver.get(baseUrl);

        waitForLoad(driver);
        Thread.sleep(5000);
    }


    @When("^user inserts (.*) and (.*)$")
    public void insert_data(String username, String password) throws InterruptedException {

        lp.insertUsername(username);
        Thread.sleep(1000);
        lp.insertPassword(password);
        Thread.sleep(1000);

    }

    @And("user clicks submit")
    public void click_submit() throws InterruptedException {

        lp.clickLogin();
        Thread.sleep(5000);
    }

    @Then("^user (.*) gets into the welcome page$")
    public void get_into_the_welcome_page(String username) {
        waitForLoad(driver);
        assertTrue(driver.getPageSource().contains(username) && driver.getCurrentUrl().contains(get_baseUrl()));
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
