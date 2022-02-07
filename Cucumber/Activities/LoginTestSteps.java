package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void navigatetoURL(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void login(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("^User enters \\\"(.*)\\\" and \\\"(.*)\\\"$")
    public void loginWithParam(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void verifyLogin(){
        System.out.println("title of page: " +driver.getTitle());
        System.out.println("Confirmation message is: "+driver.findElement(By.id("action-confirmation")).getText());

    }

    @And("^Close Browser$")
    public void closeBrowser(){
        driver.close();
    }
}
