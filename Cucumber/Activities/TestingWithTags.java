package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestingWithTags {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void navigatetoURL(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimpleAlert(){
        driver.findElement(By.id("simple")).click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void clickConfirmAlert(){
        driver.findElement(By.id("confirm")).click();
    }
    @When("^User clicks the Prompt Alert button$")
    public void clickPromptAlert(){
        driver.findElement(By.id("prompt")).click();
    }
    @Then("^Alert opens$")
    public void openAlert(){
        alert = driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void printAlertText(){
        System.out.println("Alert Text is: " +alert.getText());
    }

    @And ("^Write a custom message in it$")
    public void writeTextToPromptAlert(){
        alert.sendKeys("This is Prompt Alert");
    }

    @And ("^Close the alert$")
    public void closeAlert(){
        alert.accept();
    }

    @And ("^Close the alert with Cancel$")
    public void dismissAlert(){
        alert.dismiss();
    }

    @And ("^Read the result text$")
    public void readResultText(){
        System.out.printf("Result text: " +driver.findElement(By.xpath("//p")).getText());
    }
    @And ("^Close browser$")
    public void closeBrowser(){
        driver.close();
    }
}
