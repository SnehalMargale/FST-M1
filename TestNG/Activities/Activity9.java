package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver =  new FirefoxDriver();
        Reporter.log("Test started");
        driver.get(" https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened browser");
        System.out.printf("Title of webpage is: "+ driver.getTitle());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        Reporter.log("Focusing on main page");
        driver.switchTo().defaultContent();
    }

    @Test(priority =0)
    public void simpleAlertTestCase(){
        Reporter.log("Started simpleAlertTestCase");
        driver.findElement(By.id("simple")).click();
        Reporter.log("Switching to alert");
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert");

        String alertText = simpleAlert.getText();
        Reporter.log("Got alert text");
        Assert.assertEquals("This is a JavaScript Alert!",alertText);

        Reporter.log("Accepting alert");
        simpleAlert.accept();
        Reporter.log("Accepted alert");
        Reporter.log("Ended simpleAlertTestCase");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase(){
        Reporter.log("Started confirmAlertTestCase");
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Switching to alert");
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert");

        String alertText = confirmAlert.getText();
        Reporter.log("Got alert text");
        Assert.assertEquals("This is a JavaScript Confirmation!",alertText);

        Reporter.log("Accepting alert");
        confirmAlert.accept();
        Reporter.log("Accepted alert");
        Reporter.log("Ended confirmAlertTestCase");
    }

    @Test(priority = 2)
    public void promptAlertTestCase(){
        Reporter.log("Started promptAlertTestCase");
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Switching to alert");
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert");

        String alertText = promptAlert.getText();
        Reporter.log("Got alert text");
        Assert.assertEquals("This is a JavaScript Prompt!",alertText);

        Reporter.log("Accepting alert");
        promptAlert.accept();
        Reporter.log("Accepted alert");
        Reporter.log("Ended promptAlertTestCase");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        Reporter.log("After Method");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        Reporter.log("Closing browser");
        driver.close();
    }
}
