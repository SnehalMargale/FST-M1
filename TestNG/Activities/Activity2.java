package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void test1(){
        System.out.printf("Title of webpage is: "+ driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }

    @Test
    public void test2(){
        String btnLabel=driver.findElement(By.xpath("//button[text()='Black']")).getText();
        Assert.assertEquals(btnLabel,"About Training Support");
    }

    @Test(enabled = false)
    public void test3(){
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    @Test
    public void test4(){
        System.out.printf("in test 4");
        throw new SkipException("Skipping test case");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
