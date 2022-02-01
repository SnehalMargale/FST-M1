package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of webpage is: " + driver.getTitle());

        driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[contains(@class,\"-password\")]")).sendKeys("password");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password");
        driver.findElement(By.xpath("//input[starts-with(@name, \"email\")]")).sendKeys("test@mail.com");
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));
        wait.until(ExpectedConditions.visibilityOf(loginMsg));
        System.out.println("Login Message is: "+ loginMsg.getText());

        driver.close();
    }
}
