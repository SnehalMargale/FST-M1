package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement btn= driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        actions.moveToElement(btn);
        System.out.println("tool tip value is: "+ btn.getAttribute("data-tooltip"));
        btn.click();

        WebElement username = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());
        driver.close();
    }
}
