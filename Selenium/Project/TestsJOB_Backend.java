package ProjectJOB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestsJOB_Backend {

    WebDriver driver;
    WebDriverWait wait;
    Select jobType;

    @BeforeTest
    public void setUp()
    {
        driver =  new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Reporter.log("Test started");
        driver.get(" https://alchemy.hguy.co/jobs/wp-admin");
        Reporter.log("Opened browser");
    }

    @Test()
    public void visitBackendAndLogin() {
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertTrue(driver.findElement(By.partialLinkText("root")).isDisplayed());
    }

    @Test(dependsOnMethods = "visitBackendAndLogin")
    public void backendJobListing() throws InterruptedException {
        driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']//div[2]")).click();
        driver.findElement(By.linkText("Add New")).click();
        //html/body/div[6]/div/div/div/div/div/div/div/div[1]/button

        driver.findElement(By.id("post-title-0")).sendKeys("Senior Test Engineer");
        driver.findElement(By.name("_company_website")).sendKeys("http://CompanyName.com");
        driver.findElement(By.name("_company_twitter")).sendKeys("@CompanyName");
        driver.findElement(By.id("_job_expires")).sendKeys("February 28, 2022");
        driver.findElement(By.id("_job_location")).sendKeys("Pune");
        driver.findElement(By.name("_company_name")).sendKeys("CompanyName");
        driver.findElement(By.name("_company_tagline")).sendKeys("CompanyTagline");
        driver.findElement(By.id("_company_video")).sendKeys("https://alchemy.hguy.co/jobs");
        driver.findElement(By.id("_featured")).click();
        WebElement btnPublish = driver.findElement(By.xpath
                ("//button[@class='components-button editor-post-publish-panel__toggle" +
                        " editor-post-publish-button__button is-primary']"));
        Assert.assertTrue(btnPublish.isEnabled());

        btnPublish.click();
        driver.findElement(By.xpath("//button[@class='components-button editor-post-publish-button " +
                "editor-post-publish-button__button is-primary']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("View Job"))));
        driver.findElement(By.linkText("View Job")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='entry-title']")).getText(),"Senior Test Engineer");
        Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(),"CompanyName");

    }



    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
