package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void test(){
        System.out.printf("Title of webpage is: "+ driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Training Support");

        driver.findElement(By.linkText("About Us")).click();
        System.out.printf("Title of webpage is: "+ driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
