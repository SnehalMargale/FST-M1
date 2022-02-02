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

public class TestsJOB {

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

    @Test(priority = 0)
    public void verifyWebsiteTitle()
    {
        String websiteTitle = driver.getTitle();
        Assert.assertEquals("Alchemy Jobs – Job Board Application",websiteTitle);
    }

    @Test(priority = 1)
    public void verifyWebsiteHeading()
    {
        String websiteHeading = driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();
        Assert.assertEquals("Welcome to Alchemy Jobs",websiteHeading);
    }

    @Test(priority = 2)
    public void getImageURL()
    {
        String imgURL = driver.findElement(By.xpath("//img")).getAttribute("src");
        System.out.printf("URL of the image is: "+ imgURL);
    }

    @Test(priority = 3)
    public void verifyWebsiteSecondHeading()
    {
        String websiteSecondHeading = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        Assert.assertEquals("Quia quis non",websiteSecondHeading);
    }

    @Test(priority = 4)
    public void navigateJobsPage()
    {
        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());
    }

    @Test(priority = 5)
    public void applyToJob() {
        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());

        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
       // Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement firstJob=driver.findElement(By.xpath("//div[@class='job_listings']/ul/li[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(firstJob));

        firstJob.click();
        wait.until(ExpectedConditions.titleIs("BankingTestJob – Alchemy Jobs"));
        Assert.assertEquals("BankingTestJob – Alchemy Jobs",driver.getTitle());

        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        System.out.println("To apply for job email your details to: "+
                driver.findElement(By.linkText("abhiram@cklabs.com")).getText());
    }

    @Test(priority = 6)
    public void postJob() {
        driver.findElement(By.linkText("Post a Job")).click();
        Assert.assertEquals("Post a Job – Alchemy Jobs",driver.getTitle());

        driver.findElement(By.id("create_account_email")).sendKeys("test_8@mail.com");
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

        driver.findElement(By.id("job_preview_submit_button")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"post-5\"]/div")).getText();
        System.out.println("text: "+ text);
        Assert.assertEquals("Job listed successfully. To view your listing click here.",text);

        driver.findElement(By.linkText("Jobs")).click();
        Assert.assertEquals("Jobs – Alchemy Jobs",driver.getTitle());

        driver.findElement(By.id("search_keywords")).sendKeys("Test Job");
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/div[1]/div[4]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("Test Job",driver.findElement(By.xpath("//div[@class='job_listings']/ul/li[1]//h3")).getText());
    }


    @AfterMethod
    public void teardown()
    {
        driver.close();
    }
}
