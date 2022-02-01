package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Title of webpage is: " + driver.getTitle());
        System.out.println("handle of page is: "+ driver.getWindowHandle());

        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles are: ");
        for(String handle:windowHandles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
        }

        System.out.println("handle of page is: "+ driver.getWindowHandle());
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("Title of webpage is: " + driver.getTitle());

        String heading = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println("Heading of webpage is: " + heading);

        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles are: ");
        for(String handle:windowHandles)
            System.out.println(handle);

        driver.switchTo().activeElement();
        System.out.println("handle of page is: "+ driver.getWindowHandle());
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("Title of webpage is: " + driver.getTitle());
        heading = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("Heading of webpage is: " + heading);

        driver.close();
    }
}
