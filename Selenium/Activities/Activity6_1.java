package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage is: " + driver.getTitle());

        WebElement btnCheckbox = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.name("toggled"));

        btnCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        btnCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        driver.findElement(By.name("toggled")).click();

        driver.close();
    }
}
