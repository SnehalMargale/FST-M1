package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        driver =  new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests","ButtonTests"})
    public void test1(){
        System.out.printf("Title of webpage is: "+ driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }

    @Test(dependsOnMethods = {"test1"},groups = {"HeaderTests"})
    public void headerTest1(){
        Assert.assertEquals(driver.findElement(By.id("third-header")).getText(),"Third header");
    }

    @Test(dependsOnMethods = {"test1"},groups = {"HeaderTests"})
    public void headerTest2(){
        String color = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        Assert.assertEquals(color,"rgb(33, 186, 69)");
    }

    @Test(dependsOnMethods = {"test1"},groups = {"ButtonTests"})
    public void buttonTest1(){
        String btnText = driver.findElement(By.xpath("//button[text()='Olive']")).getText();
        Assert.assertEquals(btnText,"Olive");
    }

    @Test(dependsOnMethods = {"test1"},groups = {"ButtonTests"})
    public void buttonTest2(){
        String color= driver.findElement(By.xpath("//button[text()='Teal']")).getCssValue("color");
        Assert.assertEquals(color,"rgb(255, 255, 255)");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.close();
    }
}
