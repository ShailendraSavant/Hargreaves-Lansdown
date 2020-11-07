package myhltest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class stepDefination {
    WebDriver driver = null;

//Before hooks run before the first step of each scenario. Code to load chromedriver
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        this.driver= new ChromeDriver();
    }

//Scenario - I can login to herokuapp webiste
    @Given("^I access herokuapp website$")
    public void i_access_herokuapp_website() throws Throwable {
        // Code to load herokuapp login page
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);  // second delay added
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_valid_and(String User_Name, String Password) throws Throwable {
        //Assign User name and Password
        driver.findElement(By.id("username")).sendKeys(User_Name);
        driver.findElement(By.id("password")).sendKeys(Password);
    }

    @Then("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        //Code to click login button
        driver.findElement(By.xpath("//*[@id='login']/button")).click();
    }

    @Then("^I am successfully logged in$")
    public void i_am_successfully_logged_in() throws Throwable {
        //Code to check if user has successfully logged in
        String SecureStr = driver.findElement(By.xpath("//*[@id='content']/div/h2")).getText();
        String ExpectStr= "Secure Area";
        assertEquals(SecureStr,ExpectStr);
    }

//Scenario - Confirm 'Hello World!' is rendered after the loading bar disappears
    @Given("^I navigate to test url \"([^\"]*)\"$")
    public void i_navigate_to_test_url(String url) throws Throwable {
        // Code to load herokuapp login page
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);  // second delay added
    }

    @When("^I click on Dynamic Load link \"([^\"]*)\"$")
    public void i_click_on_Dynamic_Load_link(String link) throws Throwable {
        // Code to click - Dynamic Loading
        driver.findElement(By.linkText(link)).click();
    }

    @And("^I click on Example two link \"([^\"]*)\"$")
    public void i_click_on_Example_link(String link2) throws Throwable {
        // Code to click Example 2: Element rendered after the fact
        driver.findElement(By.linkText(link2)).click();
    }

    @And("^I click Start button$")
    public void i_click_Start_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
    }

    @Then("^Confirm Hello World! is rendered after the loading bar disappears$")
    public void confirm_Hello_World_is_rendered_after_the_loading_bar_disappears() throws Throwable {
        //Code to verify Hello World is displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        String strg = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
        Assert.assertEquals(strg,"Hello World!");
    }

//Scenario - I can click on JS confirm button
    @Given("^I click on JavaScript Alerts link \"([^\"]*)\"$")
    public void i_click_on_JavaScript_Alerts_link(String link) throws Throwable {
        //Code to click on JavaScript Alerts link
        driver.findElement(By.linkText(link)).click();
    }

    @When("^I click on JS Confirm button$")
    public void i_click_on_JS_Confirm_button() throws Throwable {
        //Code to click on J S Confirm button
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    }

    @Then("^JS Alert message is displayed$")
    public void js_Alert_message_is_displayed() throws Throwable {
        //Code to check OK or Cancel button
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String strg = driver.findElement(By.xpath("//p[@id='result']")).getText();
        assertEquals(strg,"You clicked: Ok");
    }

//After hooks run after the last step of each scenario, even when the step result is failed, undefined, pending, or skipped
    @After
    public void cleanup() throws Exception
    {
        // Test execution completed and Browser will be closed
        Thread.sleep(1000);
        driver.quit();// This will close the browser
    }
}