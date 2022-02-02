package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void test1(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String confirmMsg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmMsg,"Welcome Back, admin");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
