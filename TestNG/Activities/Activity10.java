package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    Actions actions;

    @BeforeTest
    public void beforeTest() {
        driver =  new FirefoxDriver();
        actions= new Actions(driver);
        driver.get(" https://www.training-support.net/selenium/sliders");
        System.out.printf("Title of webpage is: "+ driver.getTitle());
    }

    @Test
    public void test1(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Mid value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "50");
    }

    @Test
    public void test2(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "100");
    }
    @Test
    public void test3(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(-75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "0");
    }
    @Test
    public void test4(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(-30,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "30");
    }
    @Test
    public void test5(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.clickAndHold(slider).moveByOffset(44,0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "80");
    }



    @AfterTest(alwaysRun = true)
    public void afterTest(){
        Reporter.log("Closing browser");
        driver.close();
    }
}
