package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        driver =  new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/login-form");
    }

    @DataProvider(name="Authentication")
    public Object[][] credentials(){
        return new Object[][]{{"admin","password"}};
    }

    @Test(dataProvider = "Authentication")
    @Parameters({"username", "password"})
    public void login(String username, String password){
        System.out.printf("Title of webpage is: "+ driver.getTitle());

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.close();
    }
}
