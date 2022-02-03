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

public class testsJOB {

    WebDriver driver;
    WebDriverWait wait;
    Select jobType;

    @BeforeMethod
    public void setUp()
    {
        driver =  new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Reporter.log("Test started");
        driver.get(" https://alchemy.hguy.co/jobs");
        Reporter.log("Opened browser");
    }

    @Test()
    public void verifyWebsiteTitle()
    {
        Reporter.log("Verifying website title");
        String websiteTitle = driver.getTitle();
        Assert.assertEquals("Alchemy Jobs – Job Board Application",websiteTitle);
        Reporter.log("Verified website title successfully");
    }

    @Test(priority = 1)
    public void verifyWebsiteHeading()
    {
        Reporter.log("Verifying website heading");
        String websiteHeading = driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();
        Assert.assertEquals("Welcome to Alchemy Jobs",websiteHeading);
        Reporter.log("Verified website heading successfully");
    }

    @Test(priority = 2)
    public void getImageURL()
    {
        Reporter.log("Getting image URL");
        String imgURL = driver.findElement(By.xpath("//img")).getAttribute("src");
        System.out.println("URL of the image is: "+ imgURL);
        Reporter.log("Printed image URL to console successfully");
    }

    @Test(priority = 3)
    public void verifyWebsiteSecondHeading()
    {
        Reporter.log("Verifying website second heading");
        String websiteSecondHeading = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        Assert.assertEquals("Quia quis non",websiteSecondHeading);
        Reporter.log("Verified website second heading successfully");
    }

    @Test(priority = 4)
    public void navigateJobsPage()
    {
        Reporter.log("Navigating to Jobs page");
        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());
        Reporter.log("Navigated to Jobs page successfully");
    }

    @Test(priority = 5)
    public void applyToJob() {
        Reporter.log("Applying to job");
        Reporter.log("Navigating to Jobs page");
        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());
        Reporter.log("Navigated to Jobs page");

        Reporter.log("Searching for Banking Jobs");
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
       // Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement firstJob=driver.findElement(By.xpath("//div[@class='job_listings']/ul/li[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(firstJob));
        Reporter.log("Got results for Banking Jobs");

        Reporter.log("Getting information for searched job");
        firstJob.click();
        wait.until(ExpectedConditions.titleIs("BankingTestJob – Alchemy Jobs"));
        Assert.assertEquals("BankingTestJob – Alchemy Jobs",driver.getTitle());
        Reporter.log("Opened information page for searched job");

        Reporter.log("Applying for searched job");
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        System.out.println("To apply for job email your details to: "+
                driver.findElement(By.linkText("abhiram@cklabs.com")).getText());
        Reporter.log("Applied for searched job successfully");
    }

    @Test(priority = 6)
    public void postJob() {
        Reporter.log("Posting new job to portal");
        Reporter.log("Opening 'Post a Job' page");
        driver.findElement(By.linkText("Post a Job")).click();
        Assert.assertEquals("Post a Job – Alchemy Jobs",driver.getTitle());
        Reporter.log("Opened 'Post a Job' page");

        Reporter.log("Filling all necessary information");
        driver.findElement(By.id("create_account_email")).sendKeys("test_9@mail.com");
        driver.findElement(By.id("job_title")).sendKeys("Test Job");
        driver.findElement(By.id("job_location")).sendKeys("Pune");

        jobType = new Select(driver.findElement(By.id("job_type")));
        jobType.selectByVisibleText("Full Time");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Job Description");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("application")).sendKeys("app@email.com");

        driver.findElement(By.id("company_name")).sendKeys("CompanyName");
        driver.findElement(By.id("company_website")).sendKeys("http://CompanyName.com");
        driver.findElement(By.id("company_tagline")).sendKeys("CompanyTagline");
        driver.findElement(By.id("company_video")).sendKeys("https://alchemy.hguy.co/jobs");
        driver.findElement(By.id("company_twitter")).sendKeys("@CompanyName");
        driver.findElement(By.id("company_logo")).sendKeys("C:\\Users\\002DZT744\\Desktop\\Snehal\\Trainings\\JobLogo.png");
        driver.findElement(By.name("submit_job")).click();
        Reporter.log("Submitted job details");

        driver.findElement(By.id("job_preview_submit_button")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"post-5\"]/div")).getText();
        System.out.println("text: "+ text);
        Assert.assertEquals("Job listed successfully. To view your listing click here.",text);
        Reporter.log("Posted job details successfully");

        Reporter.log("Navigating to Jobs page to view job listing");
        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());
        Reporter.log("Navigated to Jobs page to view job listing");

        driver.findElement(By.id("search_keywords")).sendKeys("Test Job");
        Reporter.log("Searched for 'Test Job'");
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Test Job",driver.findElement(By.xpath("//div[@class='job_listings']/ul/li[1]//h3")).getText());
        Reporter.log("Job posted successfully and able to find it in job listing");
    }


    @AfterMethod
    public void teardown()
    {
        driver.close();
    }
}
